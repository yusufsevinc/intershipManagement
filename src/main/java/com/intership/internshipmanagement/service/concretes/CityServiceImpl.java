package com.intership.internshipmanagement.service.concretes;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.log4j.Log4j;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.repository.abstracts.CityDao;
import com.intership.internshipmanagement.service.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@PropertySource("classpath:messaga.properties")
public class CityServiceImpl implements CityService {


    private final CityDao cityRepository;
    private final ModelMapper modelMapper;
    private final Environment environment;


    @Override
    public void add(CityDto cityDto) {
        try {
            City city = modelMapper.map(cityDto, City.class);
            cityRepository.save(city);
        }catch (Exception e){
            Log4j.error(e.getMessage());
        }

    }

    @Override
    public City getByCity(Long cityId) {
        try {
            return cityRepository.getById(cityId);
        }catch (NotFoundException e){
          throw new NotFoundException(e.getMessage());
        }

    }


    @Override
    public List<City> getAll() {
        try {
            return this.cityRepository.getAll();
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("cityListingFailed"));
            throw new NullPointerException(e.getMessage());
        }

    }



    @Override
    public void deleteCity(Long cityId) {
        try {
            City city = this.cityRepository.getById(cityId);
            this.cityRepository.delete(city.getCityId());
        }catch (NullPointerException e ){
            Log4j.error(environment.getProperty("cityDeletionFailed"));
            throw new NullPointerException(e.getMessage());
        }


    }




}
