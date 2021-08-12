package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao   {
    List<User> getAll();
    Optional<User> getById(Long id);
    Optional<User> save(User user);
    Optional<User> update(User user);
    void delete(Long id);
}
