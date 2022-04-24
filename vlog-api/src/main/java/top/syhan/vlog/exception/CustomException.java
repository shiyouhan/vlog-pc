package top.syhan.vlog.exception;

import top.syhan.vlog.common.ResultCode;

/**
 * @program: vlog-api
 * @description: 自定义异常
 * @author: SYH
 * @create: 2022-04-23 16:48
 **/
public class CustomException extends RuntimeException {
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}