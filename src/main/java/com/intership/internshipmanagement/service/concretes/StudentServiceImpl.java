package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.dto.converter.StudentDtoConverter;
import com.intership.internshipmanagement.enums.Situations;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.repository.abstracts.StudentDao;
import com.intership.internshipmanagement.service.abstracts.*;
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
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    private final Environment environment;
    private final ModelMapper modelMapper;



    @Override
    public List<Student> getAll() {
        try {
            return this.studentDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("studentListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Student getById(Long id) {
        try {
            return studentDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundStudent"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(Student student) {
        try {
            studentDao.save(student);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Student student = studentDao.getById(id);
            this.studentDao.delete(student.getId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("studentDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public StudentSaveDto getByStudentSaveDto(Long id) {
        try {
            return modelMapper.map(studentDao.getById(id)
                    , StudentSaveDto.class);
        }catch (NullPointerException e){
            Log4j.error(environment.getProperty("failedFoundStudent"));
            throw new NotFoundException(e.getMessage());
        }
    }
}
