package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.repository.abstracts.TeacherDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class TeacherDaoImpl implements TeacherDao {


    private final EntityManager entityManager;


    public TeacherDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select teacher from Teacher  teacher");
        return query.list();
    }

    @Override
    public Teacher getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("select teacher from Teacher  teacher " +
                "where teacher.id = :id");
        query.setParameter("id", id);
        return (Teacher) query.uniqueResult();
    }

    @Override
    public void save(Teacher teacher) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(teacher);

    }

    @Override
    public Optional<Teacher> update(Teacher teacher) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE  Teacher  teacher " +
                "where teacher.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
