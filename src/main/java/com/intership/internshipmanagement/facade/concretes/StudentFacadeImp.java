package com.intership.internshipmanagement.facade.concretes;


import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.enums.Situations;
import com.intership.internshipmanagement.facade.abstracts.StudentFacade;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.service.abstracts.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentFacadeImp implements StudentFacade {

    private final CompanyService companyService;
    private final DepartmentService departmentService;
    private final TeacherService teacherDaoService;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;
    private final StudentService studentService;


    @Override
    public void save(StudentSaveDto studentSaveDto) {
        Company company = this.companyService.getById(studentSaveDto.getCompanyId());
        Department department = this.departmentService.getById(studentSaveDto.getDepartmentId());
        Teacher teacher = this.teacherDaoService.getById(studentSaveDto.getTeacherId());
        University university = this.universityService.getById(studentSaveDto.getUniversityStudentId());
        UniversityDepartment universityDepartment = this.universityDepartmentService.getById(studentSaveDto.getUniversityDepartmentStudentId());
        UniversityDegree universityDegree = this.universityDegreeService.getById(studentSaveDto.getUniversityDegreeStudentId());

        Student student = new Student();
        student.setId(studentSaveDto.getId());
        student.setEmail(studentSaveDto.getEmail());
        student.setPassword(studentSaveDto.getPassword());
        student.setFirstName(studentSaveDto.getFirstName());
        student.setLastName(studentSaveDto.getLastName());
        student.setStudentNo(studentSaveDto.getStudentNo());
        student.setPhone(studentSaveDto.getPhone());
        student.setClassNo(studentSaveDto.getClassNo());
        student.setPhotoURL(studentSaveDto.getPhotoURL());
        student.setCompany(company);
        student.setDepartment(department);
        student.setTeacher(teacher);
        student.setUniversityStudent(university);
        student.setUniversityDepartmentStudent(universityDepartment);
        student.setUniversityDegree(universityDegree);
        student.setStatus(Situations.valueOf(studentSaveDto.getStatus()));

        studentService.save(student);

    }

    @Override
    public List<Student> getAll() {

        return studentService.getAll();
    }

    @Override
    public Student getByStudent(Long studentId) {
        return studentService.getById(studentId);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentService.delete(studentId);
    }

    @Override
    public StudentSaveDto getByStudentSaveDto(Long id) {
        return studentService.getByStudentSaveDto(id);
    }
}
