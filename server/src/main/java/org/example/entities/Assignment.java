package org.example.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Assignment {
    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime dueDate;
    private final Long studentId;
    private final Long teacherId;
    private final List<PDF> files;
    private final Feedback feedback;

    public Assignment(Long id, String title, LocalDateTime createdAt,
                      LocalDateTime dueDate, Long studentId, Long teacherId, List<PDF> files,
                      Feedback feedback) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.files = files;
        this.feedback = feedback;
    }

    public record PDF(String fileName, String fileType, String content) {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public List<PDF> getFiles() {
        return files;
    }

    public Feedback getFeedback() {
        return feedback;
    }
}
