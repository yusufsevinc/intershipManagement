package com.intership.internshipmanagement.service.abstracts;


import com.intership.internshipmanagement.model.UniversityDegree;

import java.util.List;
import java.util.Optional;

public interface UniversityDegreeService {
    List<UniversityDegree> getAll();
    UniversityDegree getById(Long id);
    void save(UniversityDegree universityDegree);
    Optional<UniversityDegree> update(UniversityDegree universityDegree);
    void delete(Long id);
}
