package org.example.repositories;

import org.example.entities.User;

public interface UserRepository {
    boolean existsByUsername(String firstName, String lastName);
    void save(User user);
}
