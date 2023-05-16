package com.olympus.config;

import com.olympus.config.filter.AuthorizationFilter;
import com.olympus.config.filter.SmsCodeAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eddie.lys
 * @since 2023/4/15
 */
@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityConfig {

    private final AuthorizationFilter authorizationFilter;
    private final SmsCodeAuthenticationFilter smsCodeAuthenticationFilter;

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http){
        return http.csrf().disable()
                .authorizeExchange()

                .pathMatchers(HttpMethod.POST,"/api/login")
                .permitAll()

                .pathMatchers("/provider/**")
                .denyAll()

                .pathMatchers(HttpMethod.GET,"/api/product/**")
                .hasAnyAuthority("ADMIN","GUEST")

                .pathMatchers(HttpMethod.POST,"/api/manager/**")
                .hasAnyAuthority("ADMIN")

                .anyExchange()
                .authenticated()
                .and()
                .addFilterAt(authorizationFilter, SecurityWebFiltersOrder.AUTHORIZATION)
                .addFilterAt(smsCodeAuthenticationFilter, SecurityWebFiltersOrder.AUTHORIZATION)
                .build();
    }

    @Bean
    public ReactiveAuthenticationManager authenticationManager(ReactiveUserDetailsService userDetailsService, PasswordEncoder encoder) {
        UserDetailsRepositoryReactiveAuthenticationManager manager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        manager.setPasswordEncoder(encoder);
        return manager;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
