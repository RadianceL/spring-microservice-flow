package com.olympus.inside.service.impl;

import com.olympus.common.user.LoginTypeEnums;
import com.olympus.common.user.UserInfo;
import com.olympus.inside.ReactiveAuthenticationServiceCustomer;
import com.olympus.inside.service.AuthenticationService;
import com.olympus.utils.ServiceResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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
    private final ReactiveAuthenticationServiceCustomer authenticationServiceCustomer;

    @Override
    public Mono<UserDetails> loginByMultipleWays(String loginRef, String loginCertificate, @NotNull LoginTypeEnums loginType) {
        return switch (loginType) {
            case ACCOUNT -> authenticationServiceCustomer.internalUserInfoQuery(loginRef)
                    .map(ServiceResponseUtil::getResponseData)
                    .map(userBaseInfo -> new UserInfo(){{
                        setUsername(userBaseInfo.getUsername());
                        setPassword(userBaseInfo.getPassword());
                        setAuthoritiesRoles(userBaseInfo.getAuthoritiesRoles());
                    }})
                    .flatMap(userInfoServiceResponse -> Mono.justOrEmpty(userInfoServiceResponse));
            case PHONE_VERIFY -> authenticationServiceCustomer.internalPhoneVerifyQuery(loginRef, loginCertificate)
                    .map(ServiceResponseUtil::getResponseData)
                    .map(userBaseInfo -> new UserInfo(){{
                        setUsername(userBaseInfo.getUsername());
                        setPassword(userBaseInfo.getPassword());
                        setAuthoritiesRoles(userBaseInfo.getAuthoritiesRoles());
                    }})
                    .flatMap(userInfoServiceResponse -> Mono.justOrEmpty(userInfoServiceResponse));
            default -> Mono.empty();
        };
    }
}
