package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.repository.abstracts.UniversityDao;
import com.intership.internshipmanagement.service.abstracts.UniversityService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:messaga.properties")
public class UniversityServiceImpl implements UniversityService {

    private final UniversityDao universityDao;
    private final Environment environment;

    @Override
    public void save(University university) {
        try {
            universityDao.save(university);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }

    }

    @Override
    public Optional<University> update(University university) {
        return Optional.empty();
    }

    @Override
    public List<University> getAll() {
        try {
            return this.universityDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("universityListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public University getById(Long universityId) {
        try {
            return universityDao.getById(universityId);

        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundUniversity"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void delete(Long universityId) {
        try {
            University university = universityDao.getById(universityId);
            this.universityDao.delete(university.getUniversityId());
        }catch (NullPointerException e ){

            Log4j.error(environment.getProperty("universityDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }


    }


}
