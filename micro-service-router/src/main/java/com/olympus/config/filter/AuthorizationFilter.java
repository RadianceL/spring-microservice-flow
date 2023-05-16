package com.olympus.config.filter;

import com.alibaba.fastjson2.JSON;
import com.olympus.domain.MicroSsoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationFilter implements WebFilter {

    private final RedisTemplate<String, String> redisTemplate;

    @NonNull
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        System.out.println("filter....." + exchange.getRequest().getPath());
        if (exchange.getRequest().getPath().toString().equals("/api/login")) {
            Authentication auth = new UsernamePasswordAuthenticationToken("john", "123",
                    List.of(new SimpleGrantedAuthority("PRODUCT_GUEST")));
            return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
        }

        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (token == null) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        String info = redisTemplate.opsForValue().get(token);
        if (info == null) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        MicroSsoUser user = JSON.parseObject(info, MicroSsoUser.class);
        List<SimpleGrantedAuthority> authorities = user.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, authorities);
        // 认证对象存入到"安全上下文中"
        // 在引入reactor-core:3.4- 的版本时（由于spring-webflux项目引入），使用此方式！
//        return chain.filter(exchange).subscriberContext(ReactiveSecurityContextHolder.withAuthentication(auth));
        // 在引入reactor-core:3.4+ 的版本时，使用以下方式！
        return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
    }
}