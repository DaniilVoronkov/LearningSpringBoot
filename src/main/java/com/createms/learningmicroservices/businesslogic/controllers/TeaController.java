package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.createms.learningmicroservices.models.tables.Tea;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/Tea")
public class TeaController {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    //method that redirect to the table with all the products (in this example - with tea products)
    @RequestMapping(method = RequestMethod.GET, path = "/TeaProducts")
    public String getAllTeaProducts(Model model) {
        model.addAttribute("ProductsList", teaService.getAllTea());
        model.addAttribute("ProductClass", Tea.class.getSimpleName());
        return "ProductPages/ProductsTable";
    }

    //method that redirect to the add product form
    @GetMapping(path = "/AddProduct")
    public String addProductView(Model model) {
        model.addAttribute("ProductVariations", TeaType.values());
        return "ProductPages/AddProduct";
    }


    //deleting the object by name
    @DeleteMapping(path = "/Delete/{name}")
    @ResponseBody
    //@Transactional
    public void deleteTeaProductById(@PathVariable("name") String name) {
        teaService.deleteTeaByName(name);
    }


    //function that redirects to the edit page  (and adding data to the model)
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/EditProductPage/{name}")
    public String editProductPage(@PathVariable("name") String name, Model model) {
        model.addAttribute("ProductToEdit", teaService.findByName(name));
        List<String> test = Arrays.stream(TeaType.values()).map(TeaType::getLabel).toList();
        model.addAttribute("ProductTypes", test);
        return "ProductPages/EditProduct";
    }


    //function that performs the edit process (by redirecting to the corresponding service method)
    @PatchMapping(path = "/Edit/{id}")
    @ResponseBody
    public void editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") String id, Model model) {
        teaService.updateTea(productDTO, Long.parseLong(id));
        System.out.println(teaService.findById(Long.parseLong(id)));

    }



}
