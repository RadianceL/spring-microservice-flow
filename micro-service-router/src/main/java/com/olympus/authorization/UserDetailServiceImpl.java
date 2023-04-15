package com.olympus.authorization;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eddie.lys
 * @since 2023/4/15
 */
public class UserDetailServiceImpl implements ReactiveUserDetailsService {
    @Override
    public Mono<UserDetails> findByUsername(String username) {
//        return userRepository.findByUsername(username).map(user->{
//            List<SimpleGrantedAuthority> authorities = user.getAuthorities().stream()
//                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//            return User.withUsername(user.getUsername()).password(user.getPassword())
//                    .authorities(authorities)
//                    .build();
//        });
        return null;
    }
}
