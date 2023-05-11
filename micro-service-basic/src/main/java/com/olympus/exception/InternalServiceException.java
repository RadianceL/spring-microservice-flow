package com.olympus.exception;

import com.olympus.base.utils.support.exception.ExtendRuntimeException;
import com.olympus.base.utils.support.globalization.ErrorMessage;

/**
 * 内服服务异常
 * @author eddie.lys
 * @since 2023/5/11
 */
public class InternalServiceException extends ExtendRuntimeException {

    /**
     * 2021-09-24 由TerryQi进行优化，因为某些异常需要抛出code、message和data，所以扩展业务信息
     */
    private String message;        //异常错误码
    private Object data;        //异常扩展数据

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public InternalServiceException() {
        super();
    }

    public InternalServiceException(String error, String message, Object data) {
        super(error);
        this.message = message;
        this.data = data;
    }

    public InternalServiceException(String error) {
        super(error);
    }

    public InternalServiceException(String error, Object... args) {
        super(error);
    }


    public InternalServiceException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public InternalServiceException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
