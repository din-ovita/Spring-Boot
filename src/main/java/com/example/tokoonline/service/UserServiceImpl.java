package com.example.tokoonline.service;

import com.example.tokoonline.exception.BadRequestException;
import com.example.tokoonline.exception.EmailCondition;
import com.example.tokoonline.exception.InternalErrorException;
import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.User;
import com.example.tokoonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

//    post
    @Override
    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
           throw new EmailCondition("Email already exist");
        }
            return userRepository.save(user);

      }


//    get by id
    @Override
    public User getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memasukkan data");
        }

    }

//    update
    @Override
    public User updateUser(Integer id, String username, String email, Integer age, String address, Integer phoneNumber) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

//    get all
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

//    delete
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
