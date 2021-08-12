package com.intership.internshipmanagement.controller;


import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.facade.abstracts.StudentFacade;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.service.abstracts.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentFacade studentFacade;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;
    private final TeacherService teacherService;
    private final CompanyService companyService;
    private final DepartmentService departmentService;

    public StudentController(StudentFacade studentFacade, UniversityService universityService,
                             UniversityDepartmentService universityDepartmentService,
                             UniversityDegreeService universityDegreeService, TeacherService teacherService,
                             CompanyService companyService, DepartmentService departmentService) {
        this.studentFacade = studentFacade;
        this.universityService = universityService;
        this.universityDepartmentService = universityDepartmentService;
        this.universityDegreeService = universityDegreeService;
        this.teacherService = teacherService;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }
/**/
    @GetMapping(value = "/getall")
    public String getAll(Model model){
        try {
            model.addAttribute("student" ,  this.studentFacade.getAll());
            return "studentViews/student";
        }catch (Exception e){
             throw new NotFoundException("e.getMessage()");
        }

    }


    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        this.studentFacade.deleteStudent(studentId);
        return "redirect:/student/getall";
    }

    /**/
    @Transactional
    @RequestMapping(value ="/admin/edit/{studentId}")
    public ModelAndView editStudentForm(@PathVariable Long studentId) {
        ModelAndView modelAndView = new ModelAndView("studentViews/edit_student");
        StudentSaveDto student = studentFacade.getByStudentSaveDto(studentId);
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        List<Teacher> teachers = this.teacherService.getAll();
        List<Company> companies = this.companyService.getAll();
        List<Department> departments = this.departmentService.getAll();
        modelAndView.addObject("student" , student);
        modelAndView.addObject("university" , universities);
        modelAndView.addObject("universityDepartment" , universityDepartments);
        modelAndView.addObject("universityDegree" , universityDegrees);
        modelAndView.addObject("teacher" , teachers);
        modelAndView.addObject("company" , companies);
        modelAndView.addObject("department" , departments);

        return modelAndView;
    }



    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("uni") StudentSaveDto student) {
        this.studentFacade.save(student);
        return "redirect:/student/getall";
    }
    /**/

    @RequestMapping("/admin/edit/newStudent")
    public String newstudentForm(Map<String , Object> model) {
        StudentSaveDto student = new StudentSaveDto();
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        List<Teacher> teachers = this.teacherService.getAll();
        List<Company> companies = this.companyService.getAll();
        List<Department> departments = this.departmentService.getAll();
        model.put("student" , student);
        model.put("university" , universities);
        model.put("universityDepartment" , universityDepartments);
        model.put("universityDegree" , universityDegrees);
        model.put("teacher" , teachers);
        model.put("company" , companies);
        model.put("department" , departments);

        return "studentViews/new_student";
    }




}
