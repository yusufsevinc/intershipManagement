package com.intership.internshipmanagement.repository.abstracts;


import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDao {
    List<Student> getAll();
    Student getById(Long id);
    void save(Student student);
    Optional<Student> update(Student student);
    void delete(Long id);
}
