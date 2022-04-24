package top.syhan.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: 账号密码登录dto
 * @author: SYH
 * @create: 2022-04-23 19:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private String phone;
    private String password;
}
