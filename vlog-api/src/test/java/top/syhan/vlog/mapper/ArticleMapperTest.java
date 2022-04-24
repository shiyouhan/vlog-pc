package top.syhan.vlog.mapper;

import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.syhan.vlog.model.entity.Article;
import top.syhan.vlog.model.vo.ArticleVo;
import top.syhan.vlog.task.ArticleTask;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 21:33
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ArticleMapperTest {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insert() {
        Article article = Article.builder()
                .id("123456")
                .category("测试分类")
                .title("测试文章")
                .userId(1)
                .summary("文章摘要")
                .content("测试文章内容")
                .createTime(LocalDateTime.now())
                .totalWords("2.3k")
                .duration(2)
                .pageView(9898)
                .build();
        articleMapper.insert(article);
    }

    @Test
    void insertArticles() throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = future.get();
        int count = articleMapper.insertArticles(articles);
        System.out.println(count);
    }


    @Test
    void selectAll() {
        Page<ArticleVo> articlePage = articleMapper.selectAll();
        System.out.println(articlePage.toPageInfo().getList().size());
    }

    @Test
    void getDetail() {
        ArticleVo detail = articleMapper.getDetail("1e73910da0e64a44a730a3c43ef6bdda");
        System.out.println(detail);
    }

}