package com.intership.internshipmanagement.service.abstracts;


import com.intership.internshipmanagement.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();
    Project getById(Long id);
    void save(Project project);
    Optional<Project> update(Project project);
    void delete(Long id);
}
