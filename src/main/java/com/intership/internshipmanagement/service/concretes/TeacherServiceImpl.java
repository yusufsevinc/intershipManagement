package com.intership.internshipmanagement.service.concretes;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.repository.abstracts.TeacherDao;
import com.intership.internshipmanagement.service.abstracts.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:messaga.properties")
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;
    private final Environment environment;
    private final ModelMapper modelMapper;


    @Override
    public List<Teacher> getAll() {
        try {
            return this.teacherDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("teacherListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Teacher getById(Long id) {
        try {
            return teacherDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundTeacher"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(Teacher teacher) {
        try {
            teacherDao.save(teacher);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<Teacher> update(Teacher teacher) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Teacher teacher = teacherDao.getById(id);
            this.teacherDao.delete(teacher.getId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("teacherDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public TeacherSaveDto getByTeacherSaveDto(Long id) {
        try {
            return modelMapper.map(teacherDao.getById(id)
                    , TeacherSaveDto.class);
        }catch (NullPointerException e){
            Log4j.error(environment.getProperty("failedFoundTeacher"));
            throw new NotFoundException(e.getMessage());
        }
    }
}
