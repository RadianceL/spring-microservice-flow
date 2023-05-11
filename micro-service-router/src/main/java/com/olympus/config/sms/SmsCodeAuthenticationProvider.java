package com.olympus.config.sms;

import com.olympus.common.user.LoginTypeEnums;
import com.olympus.common.user.UserInfo;
import com.olympus.exception.InternalServiceException;
import com.olympus.inside.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author eddie.lys
 * @since 2023/5/11
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsCodeAuthenticationProvider implements ReactiveAuthenticationManager {

    /**
     * 登录鉴权
     */
    private final AuthenticationService authenticationService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String mobile = authentication.getName();
        String verifyCode = authentication.getCredentials().toString();

        UserInfo userInfo;
        try {
            userInfo = authenticationService.loginByMultipleWays(mobile, verifyCode, LoginTypeEnums.PHONE_VERIFY);
        }catch (InternalServiceException internalServiceException) {
            return Mono.error(new BadCredentialsException(internalServiceException.getMessage()));
        }
        if (Objects.isNull(userInfo)) {
            return Mono.error(new BadCredentialsException("Invalid code"));
        }
        return Mono.just(new UsernamePasswordAuthenticationToken(mobile, verifyCode, userInfo.getAuthorities()));
    }
}
