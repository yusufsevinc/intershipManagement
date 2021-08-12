package com.intership.internshipmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "university_departments")
@AllArgsConstructor
@NoArgsConstructor

public class UniversityDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_department_id")
    private Long universityDepartmentId;

    @Column(name = "university_department_name" , nullable = false)
    private String universityDepartmentName;


    @ManyToMany(mappedBy = "universityDepartments", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "universityDepartments", cascade = CascadeType.PERSIST)
    private List<University> universities;

    @OneToMany(mappedBy = "universityDepartmentStudent")
    private List<Student> universityDepartmentStudents= new ArrayList<>();

    @Override
    public String toString() {
        return "UniversityDepartment{" +
                "universityDepartmentId=" + universityDepartmentId +
                ", universityDepartmentName='" + universityDepartmentName + '\'' +
                '}';
    }
}
