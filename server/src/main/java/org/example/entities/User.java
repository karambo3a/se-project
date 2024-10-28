package org.example.entities;

public class User {
    public static class Role {
        public static final String STUDENT = "STUDENT";
        public static final String TEACHER = "TEACHER";
    }

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String role;

    public User(String firstName, String lastName, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
