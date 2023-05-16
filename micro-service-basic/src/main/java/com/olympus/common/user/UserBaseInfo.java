package com.olympus.common.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息
 *
 * @author eddie.lys
 * @since 2023/5/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseInfo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色权限
     */
    private List<String> authoritiesRoles;
}
