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
    @RequestMapping(method = RequestMethod.GET, path = "/ProductsTable")
    public String getAllTeaProducts(Model model) {
        model.addAttribute("ProductsList", teaService.getAllTea());
        model.addAttribute("ProductClass", Tea.class.getSimpleName());
        return "ProductPages/ProductsTable";
    }

    //method that redirect to the add product form
    @RequestMapping(path = "/AddProductPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String addProductView(Model model) {
        List<String> teaTypesLabels = Arrays.stream(TeaType.values()).map(TeaType::getLabel).toList();
        model.addAttribute("ProductVariations", teaTypesLabels);
        model.addAttribute("ProductClass", "Tea");
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
        Tea tea = teaService.findByName(name);
        model.addAttribute("ProductToEdit", tea);
        List<String> teaTypesLabels = Arrays.stream(TeaType.values()).map(TeaType::getLabel).toList();
        model.addAttribute("ProductTypes", teaTypesLabels);
        return "ProductPages/EditProduct";
    }


    //function that performs the edit process (by redirecting to the corresponding service method)
    @PatchMapping(path = "/Edit/{id}")
    @ResponseBody
    public void editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") String id) {
        teaService.updateTea(productDTO, Long.parseLong(id));
    }

    //function that saves entry based on the product dto
    @PutMapping(path = "/AddProduct")
    @ResponseBody
    public void addTea(@RequestBody ProductDTO productDTO) {
        teaService.saveTea(new Tea(productDTO));

    }



}
