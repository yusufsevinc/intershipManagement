package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.UniversityDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UniversityDepartmentDao  {
    List<UniversityDepartment> getAll();
    UniversityDepartment getById(Long id);
    void save(UniversityDepartment universityDepartment);
    Optional<UniversityDepartment> update(UniversityDepartment universityDepartment);
    void delete(Long id);
}
