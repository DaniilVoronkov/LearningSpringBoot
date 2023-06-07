package com.createms.learningmicroservices.businesslogic.services;


import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeaService {

    private TeaRepository teaRepository;

    @Autowired
    public TeaService(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }

    public List<Tea> getAllTea() {
        return (List<Tea>) teaRepository.findAll();
    }

    public List<ProductDTO> getAllDtos() {
        List<ProductDTO> test = new ArrayList<>();
        getAllTea().forEach(tea -> test.add(new ProductDTO(tea.getName(), tea.getPrice(), tea.getType().getLabel())));
        return test;
    }

    public long getAmountOfTeaProducts() {
        return teaRepository.count();
    }


    public void saveTea(Tea tea) {
        teaRepository.save(tea);
    }

    public void deleteTea(Tea tea) {
        teaRepository.delete(tea);
    }


    public List<Tea> findByNameWithLikeCondition(String teaName) {
        return teaRepository.findByNameLike(teaName);
    }

    public void deleteTeaById(Long id) {
          teaRepository.deleteById(id);
    }

    public void deleteTeaByName(String name) {

            teaRepository.delete(teaRepository.findByName(name));

    }

    public Tea findById(Long id) {
        if(teaRepository.findById(id).isPresent()) {
            return teaRepository.findById(id).get();
        } else {
            return null;
        }
    }



    public Tea findByName(String teaName) {
        return teaRepository.findByName(teaName);
    }

    public void updateTea(ProductDTO productDTO, Long id) {
        if(teaRepository.findById(id).isPresent()) {
            Tea tea = teaRepository.findById(id).get();
            tea.setName(productDTO.getName());
            tea.setTeaType(TeaType.getType(productDTO.getType()));
            tea.setPrice(productDTO.getPrice());
            teaRepository.save(tea);
        }

    }
}
