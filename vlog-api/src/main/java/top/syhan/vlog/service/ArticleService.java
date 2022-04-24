package top.syhan.vlog.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import top.syhan.vlog.model.entity.Article;
import top.syhan.vlog.model.vo.ArticleVo;

import java.util.List;

/**
 * @program: vlog-api
 * @description: ArticleService
 * @author: SYH
 * @create: 2022-04-23 19:53
 **/
public interface ArticleService {
    /**
     * 批量新增文章
     *
     * @param articles 文章集合
     */
    void insertArticles(List<Article> articles);


    /**
     * d查询推荐的6篇文章
     *
     * @return List<Article>
     */
    List<ArticleVo> getRecommendArticles();


    /**
     * 查询文章数据并分页
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 返回结果
     */
    PageInfo<ArticleVo> selectByPage(int pageNum, int pageSize);


    /**
     * 根据文章id查找文章详情
     *
     * @param id 文章id
     * @return Article详情
     */
    ArticleVo getDetail(@Param(value = "id") String id);


    /**
     * 发布文章
     *
     * @param article 文章
     * @return article
     */
    Article postArticle(Article article);
}

