package com.intership.internshipmanagement.service.abstracts;



import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAll();
    Student getById(Long id);
    void save(Student student);
    Optional<Student> update(Student student);
    void delete(Long id);
    StudentSaveDto getByStudentSaveDto(Long id);
}
