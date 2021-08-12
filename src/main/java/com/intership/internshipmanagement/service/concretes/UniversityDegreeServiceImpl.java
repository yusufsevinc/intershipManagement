package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.repository.abstracts.UniversityDegreeDao;
import com.intership.internshipmanagement.service.abstracts.UniversityDegreeService;
import com.intership.internshipmanagement.service.abstracts.UniversityDegreeService;
import lombok.RequiredArgsConstructor;
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
public class UniversityDegreeServiceImpl implements UniversityDegreeService {

    private final UniversityDegreeDao universityDegreeDao;
    private final Environment environment;


    @Override
    public List<UniversityDegree> getAll() {
        try {
            return this.universityDegreeDao.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("universityDegreeListingFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public UniversityDegree getById(Long id) {
        try {
            return universityDegreeDao.getById(id);
        }catch (NotFoundException e){
            Log4j.error(environment.getProperty("failedFoundUniversityDegree"));
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void save(UniversityDegree universityDegree) {
        try {
            universityDegreeDao.save(universityDegree);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }
    }

    @Override
    public Optional<UniversityDegree> update(UniversityDegree universityDegree) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            UniversityDegree universityDegree = universityDegreeDao.getById(id);
            this.universityDegreeDao.delete(universityDegree.getDegreeId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("universityDegreeDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }
    }
}
