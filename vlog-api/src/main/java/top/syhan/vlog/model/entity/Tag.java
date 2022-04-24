package top.syhan.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: 标签实体
 * @author: SYH
 * @create: 2022-04-23 19:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {
    private Integer id;
    private String tagName;
    private String tagColor;
}
