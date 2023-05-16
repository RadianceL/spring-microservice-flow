package com.olympus.controller.provider;

import com.google.common.collect.Lists;
import com.olympus.common.response.ServiceResponse;
import com.olympus.common.user.UserBaseInfo;
import com.olympus.logger.event.annotation.EventTrace;
import com.olympus.logger.event.model.LoggerType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证服务核心API
 *
 * @author eddie.lys
 * @since 2023/4/20
 */
@Slf4j
@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationServiceProvider {

    /**
     * 新建审批组
     */
    @PostMapping("/internal/user-info/query")
    @EventTrace(event = "内部接口 - 用户信息查询", loggerType = LoggerType.FORMAT)
    public ServiceResponse<UserBaseInfo> internalUserInfoQuery(@RequestParam("username") String username) {
        UserBaseInfo userInfo = new UserBaseInfo();
        userInfo.setUsername(username);
        userInfo.setPassword("0000");
        userInfo.setAuthoritiesRoles(Lists.newArrayList("AA", "ADMIN"));
        return ServiceResponse.ofSuccess(userInfo);
    }
}
