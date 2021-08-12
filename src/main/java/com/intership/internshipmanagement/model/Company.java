package com.intership.internshipmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "company_id" , referencedColumnName = "id")

public class Company extends User  implements Serializable {

    @Column(name = "name" , nullable = false , length = 200)
    private String name;

    @Column(name = "web_address" , length = 150)
    private String webAddress;

    @Column(name = "address" ,nullable = false)
    private String address;


    @ManyToOne
    @JoinColumn(name = "city_id" , nullable = false )
    private City city;


    @OneToMany(mappedBy = "company" )
    private List<Student> studentList;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
