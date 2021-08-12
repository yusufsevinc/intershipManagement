package com.intership.internshipmanagement.facade.concretes;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.facade.abstracts.TeacherFacade;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.service.abstracts.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:messaga.properties")
public class TeacherFacadeImp implements TeacherFacade {

    private final TeacherService teacherService;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;




    @Override
    public void save(TeacherSaveDto teacherSaveDto) {

        University university = this.universityService.getById(teacherSaveDto.getUniversityId());
        UniversityDepartment universityDepartment = this.universityDepartmentService.getById(teacherSaveDto.getUniversityDepartmentId());
        UniversityDegree universityDegree = this.universityDegreeService.getById(teacherSaveDto.getUniversityDegreeId());

        List<University> universities = new ArrayList<>();
        universities.add(university);


        List<UniversityDepartment> universityDepartments = new ArrayList<>();
        universityDepartments.add(universityDepartment);

        List<UniversityDegree> universityDegrees = new ArrayList<>();
        universityDegrees.add(universityDegree);

        Teacher teacher = new Teacher();
        teacher.setId(teacherSaveDto.getId());
        teacher.setFirstName(teacherSaveDto.getFirstName());
        teacher.setLastName(teacherSaveDto.getLastName());
        teacher.setEmail(teacherSaveDto.getEmail());
        teacher.setPassword(teacherSaveDto.getPassword());
        teacher.setPhone(teacherSaveDto.getPhone());
        teacher.setPhotoURL(teacherSaveDto.getPhotoURL());
        teacher.setUniversities(universities);
        teacher.setUniversityDepartments(universityDepartments);
        teacher.setDegrees(universityDegrees);


        teacherService.save(teacher);

    }

    @Override
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @Override
    public Teacher getByTeacher(Long id) {
        return teacherService.getById(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherService.delete(id);

    }

    @Override
    public TeacherSaveDto getByTeacherSaveDto(Long id) {
      return teacherService.getByTeacherSaveDto(id);

    }


}
