package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.Department;
import com.intership.internshipmanagement.repository.abstracts.DepartmentDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class DepartmentDaoImpl implements DepartmentDao {


    private final EntityManager entityManager;


    public DepartmentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select department from Department  department");
        return query.list();
    }

    @Override
    public Department getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select department from Department  department " +
                "where departmentId = :id");
        query.setParameter("id" ,id);
        return (Department) query.uniqueResult();
    }

    @Override
    public void save(Department department) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(department);

    }

    @Override
    public Optional<Department> update(Department department) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  Department  department " +
                "where departmentId = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
