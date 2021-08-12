package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.Student;
import com.intership.internshipmanagement.model.Teacher;

import java.util.List;

public interface TeacherFacade {
    void save(TeacherSaveDto teacherSaveDto);
    List<Teacher> getAll();
    Teacher getByTeacher(Long id);
    void deleteTeacher(Long id);
    TeacherSaveDto getByTeacherSaveDto(Long id);

}
