package top.syhan.vlog.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.syhan.vlog.common.Gender;
import top.syhan.vlog.model.entity.User;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 21:49
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class UserMapperTest {
    //注入UserMapper的实例
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws Exception {
        User user = User.builder()
                .phone("13951905171")
                .password("4297f44b13955235245b2497399d7a93")
                .nickname("陶然然")
                .avatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg")
                .gender(Gender.female.type)
                .birthday(LocalDate.now())
                .address("江苏南京")
                .createTime(LocalDateTime.now())
                .build();
        userMapper.insert(user);
    }

    @Test
    void findUserByPhone() throws Exception {
        User user = userMapper.findUserByPhone("13951905171");
        log.info(String.valueOf(user));
    }

    @Test
    void updateUser() throws Exception {
        User user = userMapper.findUserByPhone("13951905171");
        user.setPassword(DigestUtils.md5Hex("123123"));
        user.setNickname("陶然然");
        user.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.jpg");
        user.setGender(Gender.female.type);
        user.setBirthday(LocalDate.of(1977, 10, 24));
        user.setAddress("江苏省南京市江宁区");
        userMapper.updateUser(user);
    }
}