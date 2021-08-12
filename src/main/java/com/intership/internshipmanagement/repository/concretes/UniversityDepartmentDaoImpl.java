package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.UniversityDepartment;

import com.intership.internshipmanagement.repository.abstracts.UniversityDepartmentDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UniversityDepartmentDaoImpl implements UniversityDepartmentDao {

    private final EntityManager entityManager;

    public UniversityDepartmentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UniversityDepartment> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select universityDepartment from UniversityDepartment  universityDepartment");
        return query.list();
    }

    @Override
    public UniversityDepartment getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select universityDepartment from UniversityDepartment  universityDepartment " +
                "where universityDepartment.id = :id");
        query.setParameter("id" ,id);
        return (UniversityDepartment) query.uniqueResult();
    }

    @Override
    public void save(UniversityDepartment universityDepartment) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(universityDepartment);
    }

    @Override
    public Optional<UniversityDepartment> update(UniversityDepartment universityDepartment) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  UniversityDepartment  universityDepartment " +
                "where universityDepartment.id = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
