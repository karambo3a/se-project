package org.example;

public interface UserRepository {
    boolean existsByUsername(String firstName, String lastName);
    void save(User user);
}
