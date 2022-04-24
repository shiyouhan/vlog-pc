package top.syhan.vlog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.syhan.vlog.common.ResultCode;
import top.syhan.vlog.exception.CustomException;
import top.syhan.vlog.model.entity.Comment;
import top.syhan.vlog.model.vo.CommentVo;
import top.syhan.vlog.service.CommentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: vlog-api
 * @description: CommentController
 * @author: SYH
 * @create: 2022-04-23 16:45
 **/
@RestController
@RequestMapping(value = "/api/comment")
@Slf4j
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("{articleId}")
    public List<CommentVo> selectByArticleId(@PathVariable String articleId) {
        List<CommentVo> commentVos = commentService.selectByArticleId(articleId);
        log.info(String.valueOf(commentVos));
        //如果查找结果size为0，抛出"数据未找到"的自定义异常
        if (commentVos.size() == 0) {
            throw new CustomException(ResultCode.RESULT_CODE_DATA_NONE.message(), ResultCode.RESULT_CODE_DATA_NONE);
        }
        return commentVos;
    }

    @PostMapping("add")
    public List<CommentVo> addComment(@RequestBody Comment comment) {
        log.info(String.valueOf(comment));
        List<CommentVo> commentVos = commentService.addComment(comment);
        if (commentVos == null) {
            throw new CustomException(ResultCode.DATA_IS_WRONG.message(), ResultCode.DATA_IS_WRONG);
        }
        return commentVos;
    }
}
