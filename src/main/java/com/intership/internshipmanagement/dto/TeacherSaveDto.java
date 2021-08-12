package com.intership.internshipmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherSaveDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String photoURL;
    private Long universityId;
    private Long universityDepartmentId;
    private Long universityDegreeId;


}
