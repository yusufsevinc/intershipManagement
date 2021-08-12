package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.Teacher;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherDao {
    List<Teacher> getAll();
    Teacher getById(Long id);
    void save(Teacher teacher);
    Optional<Teacher> update(Teacher teacher);
    void delete(Long id);
}
