package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.model.Company;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDao {
    List<Company> getAll();
    Company getById(Long id);
    void save(Company company);
    Optional<Company> update(Company company);
    void delete(Long id);
}
