package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.repository.abstracts.UniversityDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UniversityDaoImpl implements UniversityDao {

    private final EntityManager entityManager;

    public UniversityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<University> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select university from University  university");

        return query.list();
    }

    @Override
    public University getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select university from University  university " +
                "where universityId = :id");

        query.setParameter("id" ,id);

        return (University) query.uniqueResult();
    }

    @Override
    public void save(University university) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(university);
    }

    @Override
    public Optional<University> update(University university) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  University  university " +
                "where universityId = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
