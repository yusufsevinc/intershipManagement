package com.intership.internshipmanagement.repository.abstracts;

import com.intership.internshipmanagement.model.City;

import java.util.List;
import java.util.Optional;


public interface CityDao {
    List<City> getAll();
    City getById(Long id);
    void save(City city);
    Optional<City> update(City city);
    void delete(Long id);
}
