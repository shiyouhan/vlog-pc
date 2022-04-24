package top.syhan.vlog.service;

import org.apache.ibatis.annotations.Param;
import top.syhan.vlog.model.entity.Comment;
import top.syhan.vlog.model.vo.CommentVo;

import java.util.List;

/**
 * @program: vlog-api
 * @description: CommentService
 * @author: SYH
 * @create: 2022-04-23 19:56
 **/
public interface CommentService {
    /**
     * 根据文章id查询评论
     *
     * @param articleId 文章id
     * @return 所有评论
     */
    List<CommentVo> selectByArticleId(String articleId);

    /**
     * 新增评论
     *
     * @param comment 新增评论对象
     * @return 所有评论视图列表
     */
    List<CommentVo> addComment(@Param("comment") Comment comment);
}

