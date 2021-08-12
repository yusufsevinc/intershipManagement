package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDepartment;

import java.util.List;

public interface UniversityDepartmentFacade {
    void save(UniversityDepartment universityDepartment);
    List<UniversityDepartment> getAll();
    UniversityDepartment getByUniversityDepartment(Long universityDepartmentId);
    void deleteUniversityDepartment(Long universityDepartmentId);
}
