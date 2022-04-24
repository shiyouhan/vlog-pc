package top.syhan.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @program: vlog-api
 * @description: User
 * @author: SYH
 * @create: 2022-04-23 19:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String phone;
    private String password;
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDate birthday;
    private String address;
    private String banner;
    private String signature;
    private LocalDateTime createTime;
}
