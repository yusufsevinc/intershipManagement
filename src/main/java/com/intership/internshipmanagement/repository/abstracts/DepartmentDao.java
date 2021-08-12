package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentDao {
    List<Department> getAll();
    Department getById(Long id);
    void save(Department department);
    Optional<Department> update(Department department);
    void delete(Long id);
}
