package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.Student;
import com.intership.internshipmanagement.repository.abstracts.StudentDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class StudentDaoImpl implements StudentDao {


    private final EntityManager entityManager;


    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select student from Student  student");
        return query.list();
    }

    @Override
    public Student getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select student from Student  student " +
                "where student.id = :id");
        query.setParameter("id" ,id);
        return (Student) query.uniqueResult();
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);

    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  Student  student " +
                "where student.id = :id");
        query.setParameter("id" ,id);
        query.executeUpdate();
    }
}
