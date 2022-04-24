package top.syhan.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: BindPhoneDto
 * @author: SYH
 * @create: 2022-04-23 19:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BindPhoneDto {
    private String phone;
    private String wxOpenId;
    private String code;
}
