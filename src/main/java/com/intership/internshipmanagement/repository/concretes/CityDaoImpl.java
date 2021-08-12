package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.repository.abstracts.CityDao;
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
public class CityDaoImpl implements CityDao {

    private final EntityManager entityManager;

    public CityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<City> getAll(){

        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select city from City  city");

        return query.list();
    }

    @Override
    public City getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select city from City  city " +
                "where cityId = :id");

        query.setParameter("id" ,id);

        return (City) query.uniqueResult();
    }

    @Override
    public void save(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);

    }

    @Override
    public Optional<City> update(City city) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  City  city " +
                "where cityId = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
