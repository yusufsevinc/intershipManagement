package com.intership.internshipmanagement.repository.concretes;

import com.intership.internshipmanagement.model.User;
import com.intership.internshipmanagement.repository.abstracts.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
