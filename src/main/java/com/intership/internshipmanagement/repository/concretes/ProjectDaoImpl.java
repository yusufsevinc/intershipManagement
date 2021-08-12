package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.repository.abstracts.ProjectDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class ProjectDaoImpl implements ProjectDao {
    
    private final EntityManager entityManager;

    public ProjectDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Project> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select project from Project  project");
        return query.list();
    }

    @Override
    public Project getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select project from Project  project " +
                "where project.id = :id");
        query.setParameter("id" ,id);
        return (Project) query.uniqueResult();
    }

    @Override
    public void save(Project project) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(project);
    }

    @Override
    public Optional<Project> update(Project project) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  Project  project " +
                "where project.id = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
