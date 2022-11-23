package com.example.tokoonline.service;

import com.example.tokoonline.model.User;

import java.util.List;

public interface UserService{
//    post
    User addUser(User user);

//    get by id
    User getUserById(Integer id);

//    put
    User updateUser(Integer id, String username, String email, Integer age, String address, Integer phoneNumber);

//    get all
    List<User> getAllUser();

//    delete
    void deleteUser(Integer id);

}
