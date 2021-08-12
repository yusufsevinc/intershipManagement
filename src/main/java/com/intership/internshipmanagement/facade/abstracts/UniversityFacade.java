package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.model.University;

import java.util.List;

public interface UniversityFacade {

    void save(University university);
    List<University> getAll();
    University getByUniversity(Long universityId);
    void deleteUniversity(Long universityId);
}
