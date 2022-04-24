package top.syhan.vlog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

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
public class Teacher {
    private String tId;
    private String tName;
}
