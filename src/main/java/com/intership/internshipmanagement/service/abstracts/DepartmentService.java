package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAll();
    Department getById(Long id);
    void save(Department department);
    Optional<Department> update(Department department);
    void delete(Long id);
}
