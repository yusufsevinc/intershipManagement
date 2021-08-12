package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.repository.abstracts.UniversityDepartmentDao;
import com.intership.internshipmanagement.service.abstracts.UniversityDepartmentService;
import lombok.RequiredArgsConstructor;
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
public class UniversityDepartmentServiceImpl implements UniversityDepartmentService {

    private final UniversityDepartmentDao universityDepartmentDao;
    private final Environment environment;


    @Override
    public List<UniversityDepartment> getAll() {
        try {
            return this.universityDepartmentDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("universityDepartmentListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public UniversityDepartment getById(Long id) {
        try {
            return universityDepartmentDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundUniversityDepartment"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(UniversityDepartment universityDepartment) {
        try {
            universityDepartmentDao.save(universityDepartment);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<UniversityDepartment> update(UniversityDepartment universityDepartment) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            UniversityDepartment universityDepartment = universityDepartmentDao.getById(id);
            this.universityDepartmentDao.delete(universityDepartment.getUniversityDepartmentId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("universityDepartmentDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }
}
