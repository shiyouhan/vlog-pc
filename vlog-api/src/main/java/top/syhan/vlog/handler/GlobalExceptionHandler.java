package top.syhan.vlog.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.syhan.vlog.common.ResponseResult;
import top.syhan.vlog.common.ResultCode;
import top.syhan.vlog.exception.CustomException;

import java.sql.SQLException;

/**
 * @program: vlog-api
 * @description: 全局统一异常处理
 * @author: SYH
 * @create: 2022-04-23 16:48
 **/
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception 异常
     * @return ResponseResult
     */
    @ExceptionHandler(value = {CustomException.class})
    @ResponseBody
    public ResponseResult sendError(CustomException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(exception.getResultCode());
    }

    /**
     * SQL异常的处理
     *
     * @param exception 异常
     * @return ResponseResult
     */
    @ExceptionHandler(value = {SQLException.class})
    @ResponseBody
    public ResponseResult sendError(SQLException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.DATABASE_ERROR);
    }

    /**
     * NPE空值异常异常的处理
     *
     * @param exception 异常
     * @return ResponseResult
     */
    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public ResponseResult sendError(NullPointerException exception) {
        log.error(exception.getMessage());
        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}
