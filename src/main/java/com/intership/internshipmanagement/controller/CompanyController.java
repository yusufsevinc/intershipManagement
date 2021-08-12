package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.facade.abstracts.CompanyFacade;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.service.abstracts.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {
    
    private final CompanyFacade companyFacade;
    private final CityService cityService;

    public CompanyController(CompanyFacade companyFacade, CityService cityService) {
        this.companyFacade = companyFacade;
        this.cityService = cityService;
    }

    /**/
    @GetMapping(value = "/getall")
    public String getAll(Model model){
        try {
            model.addAttribute("company" ,  this.companyFacade.getAll());
            return "companyViews/company";
        }catch (Exception e){
            throw new NotFoundException("e.getMessage()");
        }

    }


    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{companyId}")
    public String deleteCompany(@PathVariable Long companyId) {
        this.companyFacade.deleteCompany(companyId);
        return "redirect:/company/getall";
    }

    /**/
    @Transactional
    @RequestMapping(value ="/admin/edit/{companyId}")
    public ModelAndView editCompanyForm(@PathVariable Long companyId) {
        ModelAndView modelAndView = new ModelAndView("companyViews/edit_company");
        CompanySaveDto companySaveDto = companyFacade.getByCompanySaveDto(companyId);
        List<City> cities = this.cityService.getAll();

        modelAndView.addObject("company" , companySaveDto);
        modelAndView.addObject("city" , cities);

        return modelAndView;
    }



    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("uni") CompanySaveDto company) {
        this.companyFacade.save(company);
        return "redirect:/company/getall";
    }
    /**/

    @RequestMapping("/admin/edit/newCompany")
    public String newcompanyForm(Map<String , Object> model) {
        CompanySaveDto companySaveDto = new CompanySaveDto();
        List<City> cities = this.cityService.getAll();
        model.put("company" , companySaveDto);
        model.put("city" , cities);
        return "companyViews/new_company";
    }
}
