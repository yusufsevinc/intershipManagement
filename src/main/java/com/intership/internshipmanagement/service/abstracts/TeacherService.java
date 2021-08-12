package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getAll();
    Teacher getById(Long id);
    void save(Teacher teacher);
    Optional<Teacher> update(Teacher teacher);
    void delete(Long id);
    TeacherSaveDto getByTeacherSaveDto(Long id);

}
