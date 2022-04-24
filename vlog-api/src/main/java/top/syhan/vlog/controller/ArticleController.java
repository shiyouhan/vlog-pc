package top.syhan.vlog.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.syhan.vlog.model.entity.Article;
import top.syhan.vlog.model.vo.ArticleVo;
import top.syhan.vlog.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: vlog-api
 * @description: ArticleController
 * @author: SYH
 * @create: 2022-04-23 16:44
 **/
@RestController
@RequestMapping(value = "/api/article")
@Slf4j
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("page")
    public PageInfo<ArticleVo> getArticlesByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                 @RequestParam(name = "pageSize", defaultValue = "9", required = false) int pageSize) {
        PageInfo<ArticleVo> articlePageInfo = articleService.selectByPage(pageNum, pageSize);
        if (articlePageInfo == null) {
            throw new NullPointerException();
        }
        return articlePageInfo;
    }


    @GetMapping("recommend")
    public List<ArticleVo> getRecommend() {
        List<ArticleVo> recommendArticles = articleService.getRecommendArticles();
        if (recommendArticles == null) {
            throw new NullPointerException();
        }
        return recommendArticles;
    }

    @GetMapping("{id}")
    public ArticleVo getArticleDetail(@PathVariable String id) {
        ArticleVo detail = articleService.getDetail(id);
        if (detail == null) {
            throw new NullPointerException();
        }
        return detail;
    }


    //private int getUserId() {
    //    ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    //    assert sra != null;
    //    HttpServletRequest request = sra.getRequest();
    //    return Integer.parseInt(request.getHeader("userId"));
    //}


    @PostMapping("post")
    public Article postArticle(@RequestBody Article article) {
        log.info(String.valueOf(article));
        return articleService.postArticle(article);
    }
}
