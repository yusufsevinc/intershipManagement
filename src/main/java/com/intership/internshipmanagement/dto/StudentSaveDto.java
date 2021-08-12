package com.intership.internshipmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveDto {
    private Long id;
    private String email;
    private String password;
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
    private Long universityDegreeStudentId;
    private String status;
}
