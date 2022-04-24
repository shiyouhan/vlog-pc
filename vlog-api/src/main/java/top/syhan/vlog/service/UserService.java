package top.syhan.vlog.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;
import top.syhan.vlog.model.dto.CaptchaLoginDto;
import top.syhan.vlog.model.dto.LoginDto;
import top.syhan.vlog.model.dto.PhoneLoginDto;
import top.syhan.vlog.model.entity.User;

/**
 * @program: vlog-api
 * @description: 用户service接口
 * @author: SYH
 * @create: 2022-04-23 19:58
 **/
public interface UserService {

    /**
     * 登录
     *
     * @param loginDto 登录dto对象
     * @return boolean
     */
    boolean login(LoginDto loginDto);


    /**
     * 根据手机号查找用户
     *
     * @param phone 手机号
     * @return User
     */
    User getUser(String phone);

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return User
     */
    User getUser(@Param("id") int id);


    /**
     * 手机短信验证码登录
     *
     * @param phoneLoginDto 入参
     * @return boolean
     */
    boolean phoneLogin(PhoneLoginDto phoneLoginDto);


    /**
     * 验证码登录
     *
     * @param captchaLoginDto 入参
     * @return User
     */
    User captchaLogin(CaptchaLoginDto captchaLoginDto);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return User
     */
    User updateUser(User user);

    /**
     * 上传文件到OSS
     *
     * @param file 文件对象
     * @return 上传后的url
     */
    String uploadFile(MultipartFile file);
}

