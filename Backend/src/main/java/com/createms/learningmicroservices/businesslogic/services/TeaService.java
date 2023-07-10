package com.createms.learningmicroservices.businesslogic.services;


import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class TeaService {

    private final TeaRepository teaRepository;

    private final Validator validator;

    @Autowired
    public TeaService(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //getting all the tea products
    public List<Tea> getAllTea() {
        return (List<Tea>) teaRepository.findAll();
    }

    //getting all dto's (if we will work with DTO's)
    public List<ProductDTO> getAllDtos() {
        List<ProductDTO> test = new ArrayList<>();
        getAllTea().forEach(tea -> test.add(new ProductDTO(tea.getName(), tea.getPrice(), tea.getType().getLabel())));
        return test;
    }

    //counting the current amount of teas
    public long getAmountOfTeaProducts() {
        return teaRepository.count();
    }


    //saving the tea product in the table
    public void saveTea(@Valid Tea tea) {
        Set<ConstraintViolation<Tea>> validationResult = isValid(tea);
        if(validationResult.isEmpty()) {
            teaRepository.save(tea);
        } else {
            throw new ConstraintViolationException(validationResult);
        }

    }

    //deleting the product from the table
    public void deleteTea(Tea tea) {
        teaRepository.delete(tea);
    }

    //finding product with LIKE statement. Will be helpful when the search will be implemented.
    public List<Tea> findByNameWithLikeCondition(String teaName) {
        return teaRepository.findByNameLike(teaName);
    }

    //deleting tea from the table by id
    public void deleteTeaById(Long id) {
        if(id != null) teaRepository.deleteById(id);
        else throw new IllegalArgumentException("Id can't be null!");
    }

    //finding the product by id
    public Tea findById(Long id) {
       return teaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no Tea with given ID"));
    }

    //updating the tea product entry with the new value
    public void updateTea(ProductDTO productDTO, Long id) {
        Set<ConstraintViolation<Tea>> validationResult = isValid(new Tea(productDTO));
        if(validationResult.isEmpty()) teaRepository.update(id, productDTO.getName(), productDTO.getPrice(), TeaType.getType(productDTO.getType()));
        else throw new ConstraintViolationException(validationResult);
        teaRepository.update(id, productDTO.getName(), productDTO.getPrice(), TeaType.getType(productDTO.getType()));

    }

    public List<String> getTeaLabels() {
        return Arrays.stream(TeaType.values()).map(TeaType::getLabel).toList();
    }

    public Set<ConstraintViolation<Tea>> isValid(Tea tea) {
        return validator.validate(tea);
    }
}
