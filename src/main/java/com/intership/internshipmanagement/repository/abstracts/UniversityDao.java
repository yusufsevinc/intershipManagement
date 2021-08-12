package com.intership.internshipmanagement.repository.abstracts;


import com.intership.internshipmanagement.model.University;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityDao {
    List<University> getAll();
    University getById(Long id);
    void save(University university);
    Optional<University> update(University university);
    void delete(Long id);
}
