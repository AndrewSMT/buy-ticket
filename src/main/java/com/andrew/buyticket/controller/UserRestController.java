package com.andrew.buyticket.controller;

import com.andrew.buyticket.dto.UserDto;
import com.andrew.buyticket.models.User;
import com.andrew.buyticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserRestController {

    @Autowired
    private  UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<User> users = userService.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User u: users){
            usersDto.add(UserDto.fromUser(u));
        }
        return usersDto;
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
