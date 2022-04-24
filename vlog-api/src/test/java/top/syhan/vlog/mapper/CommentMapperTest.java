package top.syhan.vlog.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.syhan.vlog.model.entity.Comment;
import top.syhan.vlog.model.vo.CommentVo;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 21:47
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class CommentMapperTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    void selectByArticleId() {
        List<CommentVo> commentVos = commentMapper.selectByArticleId("1e73910da0e64a44a730a3c43ef6bdda");
        commentVos.forEach(commentVo -> System.out.println(commentVos));
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("1e73910da0e64a44a730a3c43ef6bdda")
                .userId(1)
                .content("测试评论")
                .createTime(LocalDateTime.now())
                .build();
        commentMapper.addComment(comment);
    }
}