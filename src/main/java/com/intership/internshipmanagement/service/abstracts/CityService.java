package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.model.City;


import java.util.List;

public interface CityService {

    void add(CityDto cityDto);

    City getByCity(Long cityId);

    List<City> getAll();
    void deleteCity(Long cityId);

}
