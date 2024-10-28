package org.example;

import org.example.controllers.UserController;
import org.example.entities.User;
import org.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUserAlreadyExists() {
        User user = new User("Ivan", "Ivanov", "passwordForIvan", User.Role.STUDENT);
        when(userService.registerNewUser(user)).thenReturn(false);
        ResponseEntity<String> response = userController.registerUser("Ivan", "Ivanov", "passwordForIvan", "STUDENT");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("User already exists", response.getBody());
        verify(userService).registerNewUser(user);
    }
}
