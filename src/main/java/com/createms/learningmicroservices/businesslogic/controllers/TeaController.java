package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import jakarta.transaction.Transactional;
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
        model.addAttribute("TeaProductsList", teaService.getAllDtos());
        return "ProductPages/ProductsTable";
    }




    @DeleteMapping(path = "/Delete/{name}")
    @ResponseBody

    //@Transactional
    public boolean deleteTeaProductById(@PathVariable("name") String name) {
        teaService.deleteTeaByName(name);
        return true;

    }

   /* @RequestMapping(path = "/Delete/{id}", method = RequestMethod.GET)
    public String returnToTheList(@PathVariable("id") Long id) {
        return "redirect:/Teas/TeaProducts";
    } */
}
