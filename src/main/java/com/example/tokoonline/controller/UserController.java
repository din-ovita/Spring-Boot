package com.example.tokoonline.controller;

import com.example.tokoonline.model.User;
import com.example.tokoonline.response.CommonResponse;
import com.example.tokoonline.response.ResponseHelper;
import com.example.tokoonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data-user")
public class UserController {
    @Autowired
    private UserService userService;

//    post
    @PostMapping
    public CommonResponse<User> addUser(@RequestBody User user) {
        return ResponseHelper.ok(userService.addUser(user));
    }

// get by id
    @GetMapping("/{id}")
    public CommonResponse<User> getUserById(@PathVariable("id") Integer id) {
        return ResponseHelper.ok(userService.getUserById(id));
    }

//    get all
    @GetMapping("/all-user")
    public CommonResponse<List<User>> getAllUser() {
        return ResponseHelper.ok(userService.getAllUser());
    }

//    update
    @PutMapping("/{id}")
    public CommonResponse<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return ResponseHelper.ok(userService.updateUser(id, user.getUsername(), user.getEmail(), user.getAge(), user.getAddress(), user.getPhoneNumber()));
    }

//    delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

















}
