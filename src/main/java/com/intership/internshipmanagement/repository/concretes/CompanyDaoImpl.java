package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.repository.abstracts.CompanyDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class CompanyDaoImpl implements CompanyDao {

    private final EntityManager entityManager;

    public CompanyDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Company> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select company from Company  company");
        return query.list();
    }

    @Override
    public Company getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select company from Company  company " +
                "where company.id = :id");

        query.setParameter("id" ,id);

        return (Company) query.uniqueResult();
    }

    @Override
    public void save(Company company) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(company);
    }

    @Override
    public Optional<Company> update(Company company) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  Company  company " +
                "where company.id = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
