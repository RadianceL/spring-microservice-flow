package com.olympus.authorization;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author eddie.lys
 * @since 2023/4/15
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
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
