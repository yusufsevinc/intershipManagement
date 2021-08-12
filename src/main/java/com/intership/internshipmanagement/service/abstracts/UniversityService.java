package com.intership.internshipmanagement.service.abstracts;


import com.intership.internshipmanagement.model.University;
import java.util.List;
import java.util.Optional;

public interface UniversityService {

    List<University> getAll();
    University getById(Long id);
    void save(University university);
    Optional<University> update(University university);
    void delete(Long id);
}
