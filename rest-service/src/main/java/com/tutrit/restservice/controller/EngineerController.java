package com.tutrit.restservice.controller;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.restservice.service.EngineerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(final EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/engineers/{name}")
    public Engineer getByName(@PathVariable String name) {
        return engineerService.findByName(name);
    }

    @PostMapping("/engineers")
    public Engineer post(@RequestBody Engineer engineer) {
        return engineerService.save(engineer);
    }
}
