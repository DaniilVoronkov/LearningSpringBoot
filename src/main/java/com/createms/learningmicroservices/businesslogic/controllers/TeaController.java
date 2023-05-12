package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/TeaPage")
public class TeaController {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllTeaProducts(Model model) {
        model.addAttribute("TeaProductsList", teaService.getAllTea());
        return "TeaProducts";
    }
}
