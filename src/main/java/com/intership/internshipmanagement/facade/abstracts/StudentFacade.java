package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.Student;

import java.util.List;

public interface StudentFacade {
    void save(StudentSaveDto studentSaveDto);
    List<Student> getAll();
    Student getByStudent(Long studentId);
    void deleteStudent(Long studentId);
    StudentSaveDto getByStudentSaveDto(Long id);

}
