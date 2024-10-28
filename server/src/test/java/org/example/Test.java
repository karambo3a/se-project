package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        User newUser = new User("Petr", "Petrov", "password2", User.Role.TEACHER);
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

    @Test
    void createTest() {
        Long id = 1L;
        Long assignmentId = 1L;
        String feedbackText = "Excellent!";
        LocalDateTime createdAt = LocalDateTime.now();
        Feedback feedback = new Feedback(id, assignmentId, feedbackText, createdAt);
        assertEquals(id, feedback.id());
        assertEquals(assignmentId, feedback.assignmentId());
        assertEquals(feedbackText, feedback.feedbackText());
        assertEquals(createdAt, feedback.createdAt());
    }

    @Test
    void createAssignment() {
        Long id = 1L;
        String title = "Homework 1";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime dueDate = createdAt.plusDays(7);
        Long studentId = 1L;
        Long teacherId = 2L;
        List<Assignment.PDF> files = Collections.emptyList();
        Feedback feedback = new Feedback(1L, id, "Initial feedback", LocalDateTime.now());
        Assignment assignment = new Assignment(id, title, createdAt, dueDate, studentId, teacherId, files, feedback);
        assertEquals(id, assignment.getId());
        assertEquals(title, assignment.getTitle());
        assertEquals(createdAt, assignment.getCreatedAt());
        assertEquals(dueDate, assignment.getDueDate());
        assertEquals(studentId, assignment.getStudentId());
        assertEquals(teacherId, assignment.getTeacherId());
        assertEquals(files, assignment.getFiles());
        assertEquals(feedback, assignment.getFeedback());
    }
}