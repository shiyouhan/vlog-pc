package top.syhan.vlog.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.syhan.vlog.model.entity.ArticleTag;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: vlog-api
 * @description: 文章视图类
 * @author: SYH
 * @create: 2022-04-23 19:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVo {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createTime;
    private String totalWords;
    private Integer duration;
    private Integer pageView;
    private List<ArticleTag> tagList;
    private List<CommentVo> commentList;
    private String nickname;
    private String avatar;
}

