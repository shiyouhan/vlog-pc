package top.syhan.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: vlog-api
 * @description: 评论实体
 * @author: SYH
 * @create: 2022-04-23 19:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Integer id;
    private String articleId;
    private Integer userId;
    private String content;
    private LocalDateTime createTime;
}
