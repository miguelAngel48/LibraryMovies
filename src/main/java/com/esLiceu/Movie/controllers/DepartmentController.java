package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Country;
import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.repository.DepartmentRepo;
import com.esLiceu.Movie.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DepartmentController {
@Autowired
DepartmentService departmentService;

    @GetMapping("/formDepartment")
    public String editDepartment(Model model, @RequestParam(required = false) Integer id){
        if (id == null ) {
            model.addAttribute("department", new Department());
        } else {
            Department department = departmentService.findById(id) ;
            model.addAttribute("department", department);
        }
        return "formDepartment";
    }
    @PostMapping("/department/save")
    public String saveDepartment(@ModelAttribute Department department){
        departmentService.saveDepartment(department);
        return "redirect:/";
    }
    @PostMapping("/department/update")
    public String updateDepartment(@ModelAttribute Department department){
        departmentService.saveDepartment(department);
        return "redirect:/";
    }

    @PostMapping("department/delete")
    public String removeDepartment(@RequestParam Integer departmentId){
        departmentService.deleteDepartment(departmentId);
        return "redirect:/";
    }
}
