package com.olympus.inside;

import com.olympus.common.response.ServiceResponse;
import com.olympus.common.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 认证服务消费端
 *
 * @author eddie.lys
 * @since 2023/5/11
 */
@FeignClient("micro-service-sso")
public interface AuthenticationServiceCustomer {
    /**
     * 内部用户查询接口
     */
    @PostMapping("/internal/user-info/query")
    ServiceResponse<UserInfo> internalUserInfoQuery(@RequestParam("username") String username);
    /**
     * 内部用户查询接口
     */
    @PostMapping("/internal/user-info/query")
    ServiceResponse<UserInfo> internalPhoneVerifyQuery(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("verifyCode") String verifyCode);
}
