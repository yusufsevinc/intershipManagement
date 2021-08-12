package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.repository.abstracts.UniversityDegreeDao;
import com.intership.internshipmanagement.repository.abstracts.UniversityDegreeDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UniversityDegreeDaoImpl implements UniversityDegreeDao {


    private final EntityManager entityManager;


    public UniversityDegreeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UniversityDegree> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select universityDegree from UniversityDegree  universityDegree");
        return query.list();
    }

    @Override
    public UniversityDegree getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select universityDegree from UniversityDegree  universityDegree " +
                "where universityDegree.id = :id");
        query.setParameter("id" ,id);
        return (UniversityDegree) query.uniqueResult();
    }

    @Override
    public void save(UniversityDegree universityDegree) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(universityDegree);
    }

    @Override
    public Optional<UniversityDegree> update(UniversityDegree universityDegree) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  UniversityDegree  universityDegree " +
                "where universityDegree.id = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
