package com.example.mybatisdemo.user;

import com.example.mybatisdemo.response.ResponseCode;
import com.example.mybatisdemo.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
