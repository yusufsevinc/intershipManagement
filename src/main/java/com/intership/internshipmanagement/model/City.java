package com.intership.internshipmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;


    @Column(name = "city_name" ,nullable = false)
    private String cityName;


    @OneToMany(mappedBy = "city")
    private List<Company> companies;

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

