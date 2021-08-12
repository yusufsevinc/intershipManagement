package com.intership.internshipmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "universities")
@NoArgsConstructor
@AllArgsConstructor
public class University  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name" , nullable = false)
    private String universityName;



    @ManyToMany(mappedBy = "universities", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;


    @OneToMany(mappedBy = "universityStudent")
    private List<Student> universityStudents;


    @ManyToMany(targetEntity = UniversityDepartment.class, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "universities_departments", joinColumns = { @JoinColumn(name = "university_id" , updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "university_department_id" , updatable = false) })
    private List<UniversityDepartment> universityDepartments;


    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
