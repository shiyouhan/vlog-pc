package top.syhan.vlog.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.syhan.vlog.mapper.UserMapper;
import top.syhan.vlog.model.dto.CaptchaLoginDto;
import top.syhan.vlog.model.dto.LoginDto;
import top.syhan.vlog.model.dto.PhoneLoginDto;
import top.syhan.vlog.model.entity.User;
import top.syhan.vlog.service.RedisService;
import top.syhan.vlog.service.UserService;
import top.syhan.vlog.util.AliyunResource;
import top.syhan.vlog.util.FileResource;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:12
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private AliyunResource aliyunResource;
    @Resource
    private FileResource fileResource;

    @Override
    public boolean login(LoginDto loginDto) {
        User user = getUser(loginDto.getPhone());
        if (user != null) {
            //对客户端传递的密码进行加密后和数据库中user的密码比较
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public boolean phoneLogin(PhoneLoginDto phoneLoginDto) {
        //无论是否存在该手机号，均先校验验证码，通过再分两种情况处理为登录和注册
        //检查redis中是否存在该手机号的记录
        boolean flag = redisService.existsKey(phoneLoginDto.getPhone());
        if (flag) {
            //取出redis中之前存储的验证码
            String saveCode = redisService.getValue(phoneLoginDto.getPhone(), String.class);
            //和前端传的验证码比对，比对成功
            if (saveCode.equalsIgnoreCase(phoneLoginDto.getCode())) {
                //查找数据库该手机号用户是否存在
                User user = getUser(phoneLoginDto.getPhone());
                //存在就登录成功
                if (user == null) {
                    //不存在该手机号,就构建新用户记录，补充必备字段写入数据库，一键注册并登录（密码留空，用户可后期修改）
                    User user1 = User.builder()
                            .phone(phoneLoginDto.getPhone())
                            .nickname("新用户")
                            .avatar("/static/default.jpg")
                            .createTime(LocalDateTime.now())
                            .build();
                    userMapper.insert(user1);
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public User captchaLogin(CaptchaLoginDto captchaLoginDto) {
        boolean flag = redisService.existsKey(captchaLoginDto.getPhone());
        if (flag) {
            String saveCode = redisService.getValue(captchaLoginDto.getPhone(), String.class);
            //验证码一致
            if (saveCode.equalsIgnoreCase(captchaLoginDto.getCaptcha())) {
                User user = getUser(captchaLoginDto.getPhone());
                if (user != null) {
                    //密码也正确
                    if (user.getPassword().equals(DigestUtils.md5Hex(captchaLoginDto.getPassword()))) {
                        return user;
                    }
                }
            }
        }
        return null;
    }


    @Override
    public User updateUser(User user) {
        //先查出数据库原用户信息
        User savedUser = getUser(user.getPhone());
        //密码字段，如果是修改密码的请求，需要将传来的密码加密
        if (!user.getPassword().equals(savedUser.getPassword())) {
            savedUser.setPassword(DigestUtils.md5Hex(user.getPassword()));
        } else {
            //否则就是修改其他信息，密码直接赋值，以免被覆盖为空
            savedUser.setPassword(user.getPassword());
        }
        savedUser.setNickname(user.getNickname());
        savedUser.setAvatar(user.getAvatar());
        savedUser.setGender(user.getGender());
        savedUser.setBirthday(user.getBirthday());
        savedUser.setAddress(user.getAddress());
        //更新数据
        userMapper.updateUser(savedUser);
        //将修改后的用户信息返回
        return savedUser;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        // 读入配置文件信息
        String endpoint = fileResource.getEndpoint();
        String accessKeyId = aliyunResource.getAccessKeyId();
        String accessKeySecret = aliyunResource.getAccessKeySecret();
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName = file.getOriginalFilename();
        // 分割文件名，获得文件后缀名
        assert fileName != null;
        String[] fileNameArr = fileName.split("\\.");
        String suffix = fileNameArr[fileNameArr.length - 1];
        //拼接得到新的上传文件名
        String uploadFiletName = fileResource.getObjectName() + UUID.randomUUID().toString() + "." + suffix;
        // 上传网络需要用的字节流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            System.err.println("上传文件出现异常");
        }
        //执行阿里云上传文件操作
        ossClient.putObject(fileResource.getBucketName(), uploadFiletName, inputStream);
        // 关闭OSSClient
        ossClient.shutdown();
        return uploadFiletName;
    }
}

