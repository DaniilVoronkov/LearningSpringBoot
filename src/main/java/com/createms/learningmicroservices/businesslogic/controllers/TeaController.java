package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.abstraction.controllers.ProductController;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Tea")
public class TeaController implements ProductController<Tea> {

    TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    //method that redirect to the table with all the products (in this example - with tea products)
    @RequestMapping(method = RequestMethod.GET, path = "/ProductsTable")
    public List<Tea> getAllProducts() {
        return teaService.getAllTea();
    }

    @Override
    @GetMapping("/{id}")
    public Tea getProduct(@PathVariable Long id) {
        return teaService.findById(id);
    }


    //deleting the object by name
    @DeleteMapping(path = "/Delete/{id}")
    @ResponseBody
    //@Transactional
    public ResponseEntity deleteProductById(@PathVariable("id") Long id) {
        teaService.deleteTeaById(id);
        return ResponseEntity.ok().build();
    }



    //function that performs the edit process (by redirecting to the corresponding service method)
    @PatchMapping(path = "/Edit/{id}")
    @ResponseBody
    public ResponseEntity editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(teaService.updateTea(productDTO, id));
    }

    //function that saves entry based on the product dto
    @PutMapping(path = "/AddProduct")
    @ResponseBody
    public void addProduct(@RequestBody ProductDTO productDTO) {
        teaService.saveTea(new Tea(productDTO));
    }



}
