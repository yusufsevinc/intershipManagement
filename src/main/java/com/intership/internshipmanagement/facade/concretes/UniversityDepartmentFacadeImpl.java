package com.intership.internshipmanagement.facade.concretes;

import com.intership.internshipmanagement.facade.abstracts.UniversityDepartmentFacade;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.service.abstracts.UniversityDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityDepartmentFacadeImpl implements UniversityDepartmentFacade {

    private final UniversityDepartmentService universityDepartmentService;

    @Override
    public void save(UniversityDepartment universityDepartment) {
        universityDepartmentService.save(universityDepartment);

    }

    @Override
    public List<UniversityDepartment> getAll() {
        return universityDepartmentService.getAll();
    }

    @Override
    public UniversityDepartment getByUniversityDepartment(Long universityDepartmentId) {
        return universityDepartmentService.getById(universityDepartmentId);
    }

    @Override
    public void deleteUniversityDepartment(Long universityDepartmentId) {
        universityDepartmentService.delete(universityDepartmentId);

    }
}
