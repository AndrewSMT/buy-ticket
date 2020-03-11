package com.andrew.buyticket.controller;

import com.andrew.buyticket.dto.AdminDto;
import com.andrew.buyticket.dto.UserDto;
import com.andrew.buyticket.models.User;
import com.andrew.buyticket.services.UserService;
import com.andrew.buyticket.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminDto result = AdminDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
