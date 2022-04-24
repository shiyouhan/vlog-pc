package top.syhan.vlog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.syhan.vlog.model.entity.Comment;
import top.syhan.vlog.model.vo.CommentVo;

import java.util.List;

/**
 * @program: vlog-api
 * @description: CommentMapper
 * @author: SYH
 * @create: 2022-04-23 19:32
 **/
public interface CommentMapper {

    /**
     * 根据文章id查询评论
     *
     * @param articleId 文章id
     * @return 文章所有评论
     */
    @Select("SELECT a.*,b.nickname,b.avatar\n" +
            "FROM t_comment a\n" +
            "LEFT JOIN\n" +
            "t_user b\n" +
            "ON\n" +
            "a.user_id = b.id\n" +
            "WHERE a.article_id = #{articleId} ORDER BY a.id DESC ")
    List<CommentVo> selectByArticleId(@Param("articleId") String articleId);

    /**
     * 新增评论
     *
     * @param comment 评论
     */
    @Insert("INSERT INTO t_comment (article_id,user_id,content,create_time) " +
            "VALUES (#{comment.articleId},#{comment.userId},#{comment.content},#{comment.createTime} )")
    void addComment(@Param("comment") Comment comment);
}

