package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerExistingStudent() {
        User newStudent = new User("Ivan", "Ivanov", "password1", User.Role.STUDENT);
        when(userRepository.existsByUsername("Ivan", "Ivanov")).thenReturn(false);
        boolean result = userService.registerNewUser(newStudent);
        assertTrue(result);
        verify(userRepository, times(1)).save(newStudent);
    }

    @Test
    void registerExistingTeacher() {
        User newUser = new User("Petr", "Petrov", "password2", User.TEACHER);
        when(userRepository.existsByUsername("Petr", "Petrov")).thenReturn(false);
        boolean result = userService.registerNewUser(newUser);
        assertTrue(result);
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    void registerNullUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.registerNewUser(null);
        });
    }

}