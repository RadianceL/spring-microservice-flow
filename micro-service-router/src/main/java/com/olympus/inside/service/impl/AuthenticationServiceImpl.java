package com.olympus.inside.service.impl;

import com.olympus.common.response.ServiceResponse;
import com.olympus.common.user.LoginTypeEnums;
import com.olympus.common.user.UserInfo;
import com.olympus.inside.AuthenticationServiceCustomer;
import com.olympus.inside.service.AuthenticationService;
import com.olympus.utils.ServiceResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eddie.lys
 * @since 2023/5/11
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationServiceImpl implements AuthenticationService {
    /**
     * 认证服务
     */
    private final AuthenticationServiceCustomer authenticationServiceCustomer;

    @Override
    public UserInfo loginByMultipleWays(String loginRef, String loginCertificate, @NotNull LoginTypeEnums loginType) {
        switch (loginType) {
            case ACCOUNT -> {
                ServiceResponse<UserInfo> userInfoServiceResponse = authenticationServiceCustomer.internalUserInfoQuery(loginRef);
                return ServiceResponseUtil.getResponseData(userInfoServiceResponse);
            }
            case PHONE_VERIFY -> {
                ServiceResponse<UserInfo> userInfoServiceResponse = authenticationServiceCustomer.internalPhoneVerifyQuery(loginRef, loginCertificate);
                return ServiceResponseUtil.getResponseData(userInfoServiceResponse);
            }
            default -> {
                return null;
            }
        }
    }
}
