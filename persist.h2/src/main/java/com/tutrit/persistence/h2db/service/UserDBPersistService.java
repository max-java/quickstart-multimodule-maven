package com.tutrit.persistence.h2db.service;

import com.tutrit.persistence.core.model.User;
import com.tutrit.persistence.core.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserDBPersistService implements UserService {

    @Override
    public User getUser() {
        return new User("FileSystem", "27");
    }
}
