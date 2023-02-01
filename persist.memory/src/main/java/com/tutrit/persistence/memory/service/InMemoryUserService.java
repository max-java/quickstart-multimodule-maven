package com.tutrit.persistence.memory.service;


import com.tutrit.persistence.core.model.User;
import com.tutrit.persistence.core.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserService implements UserService {
    @Override
    public User getUser() {
        var user = new User("InMemory", "27");
        return user;
    }
}
