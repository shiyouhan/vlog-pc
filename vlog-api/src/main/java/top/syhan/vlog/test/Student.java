package top.syhan.vlog.test;

import lombok.*;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:25
 **/
@Data
@AllArgsConstructor
@NonNull
@Builder
public class Student {
    private String sId;
    private String sName;
}

