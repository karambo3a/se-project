package org.example.controllers;

import org.example.entities.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String firstName,
                                               @RequestParam String lastName,
                                               @RequestParam String password,
                                               @RequestParam String role) {
        User user = new User(firstName, lastName, password, role);
        boolean registered = userService.registerNewUser(user);
        return registered ? ResponseEntity.ok("Registration was successful")
                : ResponseEntity.badRequest().body("User already exists");
    }
}
