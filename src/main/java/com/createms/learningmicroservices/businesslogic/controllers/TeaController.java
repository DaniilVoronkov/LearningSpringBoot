package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.tables.Tea;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Teas")
public class TeaController {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/TeaProducts")
    public String getAllTeaProducts(Model model) {
        model.addAttribute("TeaProductsList", teaService.getAllTea());
        return "TeaProducts";
    }




    @RequestMapping(path = "/Delete/{id}")
    public String deleteTeaProductById(@PathVariable("id") Long id) {
        teaService.deleteTeaById(id);
        return "redirect:/Teas/TeaProducts";
    }

   /* @RequestMapping(path = "/Delete/{id}", method = RequestMethod.GET)
    public String returnToTheList(@PathVariable("id") Long id) {
        return "redirect:/Teas/TeaProducts";
    } */
}
