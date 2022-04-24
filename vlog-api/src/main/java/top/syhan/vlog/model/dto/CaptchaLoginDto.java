package top.syhan.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: 验证码登录Dto
 * @author: SYH
 * @create: 2022-04-23 19:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaptchaLoginDto {
    private String phone;
    private String password;
    private String captcha;
}
