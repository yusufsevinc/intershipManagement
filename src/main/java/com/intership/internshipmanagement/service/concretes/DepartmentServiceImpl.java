package com.intership.internshipmanagement.service.concretes;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.model.Department;
import com.intership.internshipmanagement.repository.abstracts.DepartmentDao;
import com.intership.internshipmanagement.service.abstracts.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;
    private final Environment environment;


    @Override
    public List<Department> getAll() {
       try {
            return this.departmentDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("departmentListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Department getById(Long id) {
        try {
            return departmentDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundDepartment"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(Department department) {
        try {
            departmentDao.save(department);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<Department> update(Department department) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Department department = departmentDao.getById(id);
            this.departmentDao.delete(department.getDepartmentId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("departmentDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }
}
