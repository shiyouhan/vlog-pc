package top.syhan.vlog.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.syhan.vlog.model.entity.ArticleTag;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 21:46
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ArticleTagMapperTest {
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Test
    void insertArticleTags() {
        List<ArticleTag> articleTagList = new ArrayList<>();
        articleTagList.add(ArticleTag.builder().articleId("1").tagName("leecode").build());
        articleTagList.add(ArticleTag.builder().articleId("2").tagName("NLP").build());
        articleTagMapper.insertArticleTags(articleTagList);
    }
}