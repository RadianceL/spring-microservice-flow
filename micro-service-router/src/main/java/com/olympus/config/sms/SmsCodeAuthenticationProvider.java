package com.olympus.config.sms;

import com.olympus.common.user.LoginTypeEnums;
import com.olympus.inside.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

        return authenticationService.loginByMultipleWays(mobile, verifyCode, LoginTypeEnums.PHONE_VERIFY)
                .map(userDetails -> new UsernamePasswordAuthenticationToken(mobile, verifyCode, userDetails.getAuthorities()))
                .switchIfEmpty(Mono.error(new BadCredentialsException("Invalid code")))
                .flatMap(Mono::just);
    }
}
