package com.olympus.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统通用返回值
 *
 * @author eddie
 * @since 2020/2/5
 */
@Data
@NoArgsConstructor
public class ServiceResponse<T> {

    /**
     * 标准返回代码
     */
    private boolean success;

    /**
     * 系统信息
     */
    private String message;

    /**
     * 业务参数返回
     */
    private T data;

    public ServiceResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ServiceResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public static <T> ServiceResponse<T> ofSuccess(T resultMessage) {
        ServiceResponse<T> response = new ServiceResponse<>();
        response.setSuccess(true);
        response.setMessage("成功");
        response.setData(resultMessage);
        return response;
    }

    public static <T> ServiceResponse<T> ofError(String systemMessage) {
        ServiceResponse<T> response = new ServiceResponse<>();
        response.setSuccess(false);
        response.setMessage(systemMessage);
        return response;
    }
}
