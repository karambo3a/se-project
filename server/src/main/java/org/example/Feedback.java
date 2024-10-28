package org.example;

import java.time.LocalDateTime;

public record Feedback(Long id, Long assignmentId, String feedbackText, LocalDateTime createdAt) {
}
