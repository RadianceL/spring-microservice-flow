package com.olympus.inside;

import com.olympus.common.response.ServiceResponse;
import com.olympus.common.user.UserBaseInfo;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * 认证服务消费端
 *
 * @author eddie.lys
 * @since 2023/5/11
 */
@Component
public class ReactiveAuthenticationServiceCustomer {
    private final WebClient webClient;

    public ReactiveAuthenticationServiceCustomer(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.webClient = WebClient.builder().filter(lbFunction).baseUrl("http://micro-service-sso/provider").build();
    }

    public Mono<ServiceResponse<UserBaseInfo>> internalUserInfoQuery(String username) {
        return webClient.post()
                .uri("/internal/user-info/query")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("username=" + username)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>(){});
    }

    public Mono<ServiceResponse<UserBaseInfo>> internalPhoneVerifyQuery(String phoneNumber, String verifyCode) {
        return webClient.post()
                .uri("/internal/user-info/query?phoneNumber={phoneNumber}&verifyCode={verifyCode}", phoneNumber, verifyCode)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>(){});
    }
}