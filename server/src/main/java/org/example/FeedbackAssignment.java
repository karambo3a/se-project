package org.example;

import java.util.List;

public interface FeedbackAssignment {
    boolean existsById(Long id);
    void save(Feedback feedback);
    List<Feedback> findByAssignmentId(Long assignmentId);
    Feedback findById(Long id);
}
