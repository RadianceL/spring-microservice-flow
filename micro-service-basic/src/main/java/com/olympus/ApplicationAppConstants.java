package com.olympus;

/**
 * 工程常量池
 *
 * @author eddie
 * @since 2020/1/5
 */
public class ApplicationAppConstants {

    /* 系统标准返回码 */
    /**
     * 请求成功
     */
    public static final String STATE_OK = "0";

    /**
     * 系统默认错误
     */
    public static final String STATE_FAILED = "1001";

    /**
     * 登录短信验证码输入错误
     */
    public static final String RESPONSE_CODE_SMS = "9998";

    /**
     * token无效
     */
    public static final String RESPONSE_CODE_TOKEN = "9001";

    /**
     * 用户信息不存在
     */
    public static final String RESPONSE_CODE_USER = "9002";
    /**
     * 用户登陆TOKEN
     */
    public static final String RESPONSE_LOGIN_TOKEN = "9003";

    /**
     * 用户信息不存在
     */
    public static final String RESPONSE_CODE_IP_PERMISSIONS = "9003";

    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "9005";

    /* 正则表达 */
    /**
     * 电话号正则表达式
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    /* http约定 */
    /**
     * 请求ID
     */
    public static final String REQUEST_ID = "requestId";

    /**
     * 请求头中的来源ID
     */
    public static final String APP_KEY = "x-request-code";

    /**
     * 请求的token
     */
    public static final String APP_TOKEN = "x-user-token";

}
