package org.example;

import java.util.List;

public interface AssignmentRepository {
    boolean existsById(Long id);
    void save(Assignment assignment);
    List<Assignment> findByStudentId(Long studentId);
    List<Assignment> findByTeacherId(Long teacherId);
    Assignment findById(Long id);
}
