package com.intership.internshipmanagement.facade.concretes;

import com.intership.internshipmanagement.facade.abstracts.UniversityFacade;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.service.abstracts.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UniversityFacadeImpl implements UniversityFacade {

    private final UniversityService universityService;


    @Override
    public void save(University university) {
        universityService.save(university);
    }

    @Override
    public List<University> getAll() {
        return universityService.getAll();
    }

    @Override
    public University getByUniversity(Long universityId) {
        return universityService.getById(universityId);
    }

    @Override
    public void deleteUniversity(Long universityId) {
        universityService.delete(universityId);

    }
}
