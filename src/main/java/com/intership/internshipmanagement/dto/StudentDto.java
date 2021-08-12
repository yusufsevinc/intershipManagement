package com.intership.internshipmanagement.dto;

import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto{

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String studentNo;
    private String phone;
    private String classNo;
    private String photoURL;
    private Long companyId;
    private Long departmentId;
    private Long teacherId;
    private Long universityStudentId;
    private Long universityDepartmentStudentId;
    private String status;







}
