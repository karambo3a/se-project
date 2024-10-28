package org.example.services;

import org.example.entities.User;
import org.example.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerNewUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User should be non null");
        }

        if (userRepository.existsByUsername(user.getFirstName(), user.getLastName())) {
            return false;
        }

        userRepository.save(user);
        return true;
    }
}
