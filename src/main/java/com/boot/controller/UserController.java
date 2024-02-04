package com.boot.controller;

import com.boot.entity.user.User;
import com.boot.service.CrudService;
import com.boot.service.user.UserServiceImpl;
import com.boot.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private CrudService<User> userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        CommonUtil.printJson(user);
        return userService.save(user);
    }

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        ResponseEntity<List<User>> response = userService.fetchAll();
        CommonUtil.printJson(response);
        return response;
    }
}
