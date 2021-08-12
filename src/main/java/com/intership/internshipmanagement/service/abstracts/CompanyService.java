package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getAll();
    Company getById(Long id);
    void save(Company company);
    Optional<Company> update(Company company);
    void delete(Long id);
    CompanySaveDto getByCompanySaveDto(Long id);

}
