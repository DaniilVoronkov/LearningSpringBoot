package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.abstraction.controllers.ProductController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.createms.learningmicroservices.models.tables.Tea;


@Controller
@RequestMapping("/Tea")
public class TeaController implements ProductController {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    //method that redirect to the table with all the products (in this example - with tea products)
    @RequestMapping(method = RequestMethod.GET, path = "/ProductsTable")
    public String getAllProducts(Model model) {
        model.addAttribute("ProductsList", teaService.getAllTea());
        model.addAttribute("ProductClass", Tea.class.getSimpleName());
        return "ProductPages/ProductsTable";
    }

    //method that redirect to the add product form
    @RequestMapping(path = "/AddProductPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAddProductPage(Model model) {
        model.addAttribute("ProductVariations", teaService.getTeaLabels());
        model.addAttribute("ProductClass", Tea.class.getSimpleName());
        return "ProductPages/AddProduct";
    }




    //deleting the object by name
    @DeleteMapping(path = "/Delete/{id}")
    @ResponseBody
    //@Transactional
    public void deleteProductById(@PathVariable("id") Long id) {
        teaService.deleteTeaById(id);
    }


    //function that redirects to the edit page  (and adding data to the model)
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/EditProductPage/{id}")
    public String getEditProductPage(@PathVariable("id") Long id, Model model) {
        Tea tea = teaService.findById(id);
        model.addAttribute("ProductToEdit", tea);
        model.addAttribute("ProductTypes", teaService.getTeaLabels());
        return "ProductPages/EditProduct";
    }


    //function that performs the edit process (by redirecting to the corresponding service method)
    @PatchMapping(path = "/Edit/{id}")
    @ResponseBody
    public String editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        teaService.updateTea(productDTO, id);
        return "redirect:/getAllProducts";
    }

    //function that saves entry based on the product dto
    @PutMapping(path = "/AddProduct")
    @ResponseBody
    public void addProduct(@RequestBody ProductDTO productDTO) {
        teaService.saveTea(new Tea(productDTO));

    }



}
