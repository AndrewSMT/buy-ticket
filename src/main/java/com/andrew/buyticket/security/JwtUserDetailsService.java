package com.andrew.buyticket.security;

import com.andrew.buyticket.models.User;
import com.andrew.buyticket.repositories.UserRepository;
import com.andrew.buyticket.security.jwt.JwtUser;
import com.andrew.buyticket.security.jwt.JwtUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userByUsername = userRepository.findByUsername(s);
        if(userByUsername == null){
            throw new UsernameNotFoundException("User not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(userByUsername);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded",s);
        return jwtUser;
    }
}
