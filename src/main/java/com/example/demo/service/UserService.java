package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    List<Object> isUserPresent(User user);
}
