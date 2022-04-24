package top.syhan.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: 文本的标签实体类
 * @author: SYH
 * @create: 2022-04-23 19:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleTag {
    private Integer id;
    private String articleId;
    private String tagName;
}
