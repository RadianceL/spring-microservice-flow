package com.olympus.common.user;

/**
 * 登录方式
 *
 * @author eddie.lys
 * @since 2023/5/11
 */
public enum LoginTypeEnums {
    /**
     * 账号密码登录
     */
    ACCOUNT,
    /**
     * 短信验证码登录
     */
    PHONE_VERIFY,
    /**
     * 微信扫码登录
     */
    WECHAT
}
