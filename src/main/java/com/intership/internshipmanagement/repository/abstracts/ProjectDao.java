package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectDao {
    List<Project> getAll();
    Project getById(Long id);
    void save(Project project);
    Optional<Project> update(Project project);
    void delete(Long id);
}
