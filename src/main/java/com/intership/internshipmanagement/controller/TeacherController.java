package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.facade.abstracts.TeacherFacade;
import com.intership.internshipmanagement.facade.concretes.TeacherFacadeImp;
import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.service.abstracts.UniversityDegreeService;
import com.intership.internshipmanagement.service.abstracts.UniversityDepartmentService;
import com.intership.internshipmanagement.service.abstracts.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {


    private final TeacherFacade teacherFacade;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;

    public TeacherController(TeacherFacade teacherFacade,
                             UniversityService universityService,
                             UniversityDepartmentService universityDepartmentService,
                             UniversityDegreeService universityDegreeService) {
        this.teacherFacade = teacherFacade;
        this.universityService = universityService;
        this.universityDepartmentService = universityDepartmentService;
        this.universityDegreeService = universityDegreeService;
    }



    @GetMapping(value = "/getall")
    public String getall(Model model) {
        model.addAttribute("teacher", teacherFacade.getAll());
        return "teacherViews/teacher";
    }



    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{teacherId}")
    public String deleteTeacher(@PathVariable Long teacherId) {
        this.teacherFacade.deleteTeacher(teacherId);
        return "redirect:/teacher/getall";
    }
/**/
    @Transactional
    @RequestMapping(value ="/admin/edit/{teacherId}")
    public ModelAndView editTeacherForm(@PathVariable Long teacherId) {
        ModelAndView modelAndView = new ModelAndView("teacherViews/edit_teacher");
        TeacherSaveDto teacher = teacherFacade.getByTeacherSaveDto(teacherId);
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        modelAndView.addObject("teacher" , teacher);
        modelAndView.addObject("university" , universities);
        modelAndView.addObject("universityDepartment" , universityDepartments);
        modelAndView.addObject("universityDegree" , universityDegrees);
        return modelAndView;
    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") TeacherSaveDto teacher) {
        this.teacherFacade.save(teacher);
        return "redirect:/teacher/getall";
    }
    /**/

    @RequestMapping("/admin/edit/newTeacher")
    public String newTeacherForm(Map<String, Object> model) {
        TeacherSaveDto teacher = new TeacherSaveDto();
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        model.put("teacher" , teacher);
        model.put("university" , universities);
        model.put("universityDepartment" , universityDepartments);
        model.put("universityDegree" , universityDegrees);

        return "teacherViews/new_teacher";
    }
}