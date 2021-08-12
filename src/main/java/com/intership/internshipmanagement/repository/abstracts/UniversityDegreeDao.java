package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityDegreeDao {
    List<UniversityDegree> getAll();
    UniversityDegree getById(Long id);
    void save(UniversityDegree universityDegree);
    Optional<UniversityDegree> update(UniversityDegree universityDegree);
    void delete(Long id);
}
