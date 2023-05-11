package com.olympus.inside.service;

import com.olympus.common.user.LoginTypeEnums;
import com.olympus.common.user.UserInfo;
import org.jetbrains.annotations.NotNull;

/**
 * @author eddie.lys
 * @since 2023/5/11
 */
public interface AuthenticationService {

    /**
     * 通过用户名查询
     * @param loginRef      登录索引
     * @param loginType     登录方式
     */
    UserInfo loginByMultipleWays(String loginRef, String loginCertificate, @NotNull LoginTypeEnums loginType);
}
