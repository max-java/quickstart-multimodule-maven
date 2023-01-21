package com.tutrit.restservice;

import com.tutrit.repo.core.bean.User;
import com.tutrit.repo.core.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final UserService userService;

    public HomeController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User getUser() {
        return userService.getUser();
    }
}
