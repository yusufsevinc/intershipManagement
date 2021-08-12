package com.intership.internshipmanagement.facade.concretes;

import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.facade.abstracts.CompanyFacade;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.service.abstracts.CityService;
import com.intership.internshipmanagement.service.abstracts.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyFacadeImpl implements CompanyFacade {

    private final CityService cityService;
    private final CompanyService companyService;

    @Override
    public void save(CompanySaveDto companySaveDto) {
        City city = cityService.getByCity(companySaveDto.getCityId());
        Company company = new Company();
        company.setEmail(companySaveDto.getEmail());
        company.setPassword(companySaveDto.getPassword());
        company.setId(companySaveDto.getId());
        company.setAddress(companySaveDto.getAddress());
        company.setName(companySaveDto.getName());
        company.setWebAddress(companySaveDto.getWebAddress());
        company.setCity(city);

        this.companyService.save(company);

    }

    @Override
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @Override
    public Company getByCompany(Long companyId) {
        return companyService.getById(companyId);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyService.delete(companyId);

    }

    @Override
    public CompanySaveDto getByCompanySaveDto(Long id) {
        return companyService.getByCompanySaveDto(id);
    }
}
