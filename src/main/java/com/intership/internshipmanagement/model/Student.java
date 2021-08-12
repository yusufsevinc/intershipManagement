package com.intership.internshipmanagement.model;


import com.intership.internshipmanagement.enums.Situations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "student_id" , referencedColumnName = "id")

public class Student extends User  implements Serializable {

    @Column(name = "first_name" , nullable = false ,length = 70)
    private String firstName;
    @Column(name = "last_name" , nullable = false ,length = 70)
    private String lastName;
    @Column(name = "student_no" , nullable = false ,length = 70 )
    private String studentNo;
    @Column(name = "phone" , nullable = false ,length = 70 , unique = true)
    private String phone;
    @Column(name = "class_no" , nullable = false ,length = 70)
    private String classNo;
    @Column(name = "photo_URL" , nullable = false ,length = 70)
    private String photoURL;


    @ManyToOne
    @JoinColumn(name = "company_id" )
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id"  )
    private Department department;

    @ManyToOne
    @JoinColumn(name = "teacher_id" , nullable = false )
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "university_id" , nullable = false)
    private University universityStudent;

    @ManyToOne
    @JoinColumn(name = "university_department_id" , nullable = false)
    private UniversityDepartment universityDepartmentStudent;

    @ManyToOne
    @JoinColumn(name = "university_degree_id" , nullable = false)
    private UniversityDegree universityDegree;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Project> projects;

    @Column(name = "status"  ,length = 70)
    private Situations status;




}
