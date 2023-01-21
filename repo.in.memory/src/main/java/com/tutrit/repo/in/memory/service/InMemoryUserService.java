package com.tutrit.repo.in.memory.service;

import com.tutrit.repo.core.bean.User;
import com.tutrit.repo.core.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserService implements UserService {
    @Override
    public User getUser() {
        var user = new User();
        user.setUserName("InMemory");
        user.setAge("27");
        return user;
    }
}
