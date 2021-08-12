package com.intership.internshipmanagement.service.concretes;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.repository.abstracts.ProjectDao;
import com.intership.internshipmanagement.service.abstracts.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:messaga.properties")
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectDao projectDao;
    private final Environment environment;

    @Override
    public List<Project> getAll() {
        try {
            return this.projectDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("projectListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Project getById(Long id) {
        try {
            return projectDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundProject"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(Project project) {
        try {
            projectDao.save(project);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<Project> update(Project project) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Project project = projectDao.getById(id);
            this.projectDao.delete(project.getProjectId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("projectDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }
}
