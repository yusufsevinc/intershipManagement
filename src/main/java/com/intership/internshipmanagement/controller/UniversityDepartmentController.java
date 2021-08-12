package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.facade.abstracts.UniversityDepartmentFacade;
import com.intership.internshipmanagement.model.UniversityDepartment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

@Controller
@RequestMapping(value = "/universityDepartment")
public class UniversityDepartmentController {


    private final UniversityDepartmentFacade universityDepartmentFacade;

    public UniversityDepartmentController(UniversityDepartmentFacade universityDepartmentFacade) {
        this.universityDepartmentFacade = universityDepartmentFacade;
    }

    /**/
    @GetMapping(value = "/getall")
    public String getAll(Model model) {
        model.addAttribute("universityDepartment", universityDepartmentFacade.getAll());
        return "universityDepartmentsViews/university_department";

    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{universityDepartmentId}")
    public String delete(@PathVariable Long universityDepartmentId) {
        this.universityDepartmentFacade.deleteUniversityDepartment(universityDepartmentId);
        return "redirect:/universityDepartment/getall";

    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/{universityDepartmentId}")
    public ModelAndView editUniversityDepartmentForm(@PathVariable Long universityDepartmentId) {
        ModelAndView modelAndView = new ModelAndView("universityDepartmentsViews/edit_university_department");
        UniversityDepartment universityDepartment = universityDepartmentFacade.getByUniversityDepartment(universityDepartmentId);
        modelAndView.addObject("uniDepartment", universityDepartment);
        return modelAndView;
    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveUniversityDepartment(@ModelAttribute("uniDepartment") UniversityDepartment universityDepartment) {
        this.universityDepartmentFacade.save(universityDepartment);
        return "redirect:/universityDepartment/getall";
    }

    /**/
    @RequestMapping("/admin/edit/newUniversityDepartment")
    public String newUniversityForm(Map<String, Object> model) {
        UniversityDepartment universityDepartment = new UniversityDepartment();
        model.put("uniDepartment", universityDepartment);
        return "universityDepartmentsViews/new_university_department";
    }
}
