package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.controllers;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("status/check")
    public String status() {
        return "Working on" ;
    }
}
