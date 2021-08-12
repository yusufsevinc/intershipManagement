package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.model.Company;

import java.util.List;

public interface CompanyFacade {
    void save(CompanySaveDto companySaveDto);
    List<Company> getAll();
    Company getByCompany(Long companyId);
    void deleteCompany(Long companyId);
    CompanySaveDto getByCompanySaveDto(Long id);
}
