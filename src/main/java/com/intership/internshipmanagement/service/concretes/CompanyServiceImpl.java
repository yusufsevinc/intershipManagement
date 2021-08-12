package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.repository.abstracts.CompanyDao;
import com.intership.internshipmanagement.service.abstracts.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:messaga.properties")
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;
    private final Environment environment;
    private final ModelMapper modelMapper;



    @Override
    public List<Company> getAll() {
        try {
            return this.companyDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("companyListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Company getById(Long id) {
        try {
            return companyDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundCompany"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(Company company) {
        try {
            companyDao.save(company);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<Company> update(Company company) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Company company = companyDao.getById(id);
            this.companyDao.delete(company.getId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("companyDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public CompanySaveDto getByCompanySaveDto(Long id) {
        try {
            return modelMapper.map(companyDao.getById(id)
                    , CompanySaveDto.class);
        }catch (NullPointerException e){
            Log4j.error(environment.getProperty("failedFoundCompany"));
            throw new NotFoundException(e.getMessage());
        }
    }

}
