package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.tables.Tea;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Teas")
public class TeaController {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/TeaProducts")
    public String getAllTeaProducts(Model model) {
        model.addAttribute("ProductsList", teaService.getAllTea());
        return "ProductPages/ProductsTable";
    }



    //deleting the object by name
    @DeleteMapping(path = "/Delete/{name}")
    @ResponseBody
    //@Transactional
    public void deleteTeaProductById(@PathVariable("name") String name) {
        teaService.deleteTeaByName(name);
    }

    //function that redirects to the edit page  (and adding data to the model)
    @RequestMapping(method = RequestMethod.GET, path = "/EditProductPage/{name}")
    public String editProductPage(@PathVariable("name") String name, Model model) {

        model.addAttribute("ProductToEdit", teaService.findByName(name));
        List<String> test = Arrays.stream(TeaType.values()).map(TeaType::getLabel).toList();
        model.addAttribute("TeaTypes", test);
        return "ProductPages/EditProduct";
    }

    //function that performs the edit process
    @RequestMapping(path = "/Edit/{id}", method = RequestMethod.PATCH)
    @ResponseBody
    public boolean editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") String id) {
        teaService.updateTea(productDTO, Long.parseLong(id));
        return true;
    }



   /* @RequestMapping(path = "/Delete/{id}", method = RequestMethod.GET)
    public String returnToTheList(@PathVariable("id") Long id) {
        return "redirect:/Teas/TeaProducts";
    } */
}
