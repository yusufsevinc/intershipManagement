package com.intership.internshipmanagement.dto;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto{

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String photoUrl;
    private List<University> universityId;
    private List<UniversityDepartment> universityDepartmentId;


}
