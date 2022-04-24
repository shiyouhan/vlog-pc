package top.syhan.vlog.service.impl;

import org.springframework.stereotype.Service;
import top.syhan.vlog.mapper.CommentMapper;
import top.syhan.vlog.model.entity.Comment;
import top.syhan.vlog.model.vo.CommentVo;
import top.syhan.vlog.service.CommentService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: vlog-api
 * @description: CommentServiceImpl
 * @author: SYH
 * @create: 2022-04-23 20:06
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVo> selectByArticleId(String articleId) {
        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public List<CommentVo> addComment(Comment comment) {
        //补充评论时间
        comment.setCreateTime(LocalDateTime.now());
        //插入
        commentMapper.addComment(comment);
        //查出这篇文章最新的评论列表
        return commentMapper.selectByArticleId(comment.getArticleId());
    }
}

