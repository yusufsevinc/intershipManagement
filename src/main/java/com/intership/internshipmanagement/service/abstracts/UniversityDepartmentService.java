package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.model.UniversityDepartment;
import java.util.List;
import java.util.Optional;

public interface UniversityDepartmentService {
    List<UniversityDepartment> getAll();
    UniversityDepartment getById(Long id);
    void save(UniversityDepartment universityDepartment);
    Optional<UniversityDepartment> update(UniversityDepartment universityDepartment);
    void delete(Long id);
}
