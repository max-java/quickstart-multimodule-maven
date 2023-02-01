package com.tutrit.restservice;

import com.tutrit.persistence.core.model.User;
import com.tutrit.persistence.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final UserService userService;

    public HomeController(@Autowired(required = false) final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User getUser() {
        return userService.getUser();
    }
}
