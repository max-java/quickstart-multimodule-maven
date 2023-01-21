package com.tutrit.repo.filesystem.service;

import com.tutrit.repo.core.bean.User;
import com.tutrit.repo.core.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class FileSystemUserService implements UserService {

    @Override
    public User getUser() {
        var user = new User();
        user.setUserName("FileSystem");
        user.setAge("27");
        return user;
    }
}
