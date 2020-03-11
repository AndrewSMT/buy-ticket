package com.andrew.buyticket.services.impl;

import com.andrew.buyticket.models.Role;
import com.andrew.buyticket.models.Status;
import com.andrew.buyticket.models.User;
import com.andrew.buyticket.repositories.RoleRepository;
import com.andrew.buyticket.repositories.UserRepository;
import com.andrew.buyticket.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user {} successfully registere", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll -  {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String name) {
        User result = userRepository.findByUsername(name);
        log.info("IN findByUsername -user: {} found by username: {}", result, name);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null){
            log.info("IN findById - no user found by id:{}", id);
            return null;
        }
            log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} ", id);
    }
}
