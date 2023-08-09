package businesslogic.controllers;

import businesslogic.services.TeaService;
import models.abstraction.classesabstraction.ProductDTO;
import models.abstraction.controllers.ProductController;
import models.enums.TeaType;
import models.tables.Tea;
import org.springframework.http.ResponseEntity;
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
    public void deleteProductById(@PathVariable("id") Long id) {
        teaService.deleteTeaById(id);
    }

    //function that performs the edit process (by redirecting to the corresponding service method)
    @PatchMapping(path = "/Edit/{id}")
    @ResponseBody
    public void editProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        teaService.updateTea(productDTO, id);
    }

    @GetMapping(path = "/EditProductPage/{id}")
    @ResponseBody
    public ResponseEntity<Tea> editProductPage(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teaService.findById(id));
    }

    //function that saves entry based on the product dto
    @PutMapping(path = "/AddProduct")
    @ResponseBody
    public void addProduct(@RequestBody ProductDTO productDTO) {
        teaService.saveTea(new Tea(productDTO));
    }

    //getting all labels from TeaType enum
    @GetMapping(path = "/allTeaTypes")
    public List<String> getAllTypes() {
        return TeaType.getAllLabels();
    }



}
