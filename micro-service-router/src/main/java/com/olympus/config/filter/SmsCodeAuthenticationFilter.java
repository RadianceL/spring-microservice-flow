package com.olympus.config.filter;

import com.olympus.config.sms.SmsCodeAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author eddie.lys
 * @since 2023/5/11
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsCodeAuthenticationFilter implements WebFilter {

    private final String MOBILE_PARAMETER = "mobile";
    private final String CODE_PARAMETER = "code";

    @Override
    public @NotNull Mono<Void> filter(@NotNull ServerWebExchange exchange, @NotNull WebFilterChain chain) {
        if (isAuthenticationRequest(exchange)) {
            return authenticate(exchange);
        } else {
            return chain.filter(exchange);
        }
    }

    private Mono<Void> authenticate(ServerWebExchange exchange) {
        String mobile = exchange.getRequest().getQueryParams().getFirst(MOBILE_PARAMETER);
        String code = exchange.getRequest().getQueryParams().getFirst(CODE_PARAMETER);
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(code)) {
            return Mono.error(new BadCredentialsException("Invalid mobile or code"));
        }
        SmsCodeAuthenticationToken token = new SmsCodeAuthenticationToken(mobile, code);
        Authentication authenticate = Objects.requireNonNull(exchange.getApplicationContext()).getBean(AuthenticationManager.class)
                .authenticate(token);
        exchange.getAttributes().put(Authentication.class.getName(), authenticate);
        return exchange.getSession()
                .doOnSuccess(session -> session.getAttributes().put(Authentication.class.getName(), authenticate))
                .then();
    }

    private boolean isAuthenticationRequest(ServerWebExchange exchange) {
        return exchange.getRequest().getURI().getPath().endsWith("/login/sms")
                && exchange.getRequest().getQueryParams().containsKey(MOBILE_PARAMETER)
                && exchange.getRequest().getQueryParams().containsKey(CODE_PARAMETER);
    }
}