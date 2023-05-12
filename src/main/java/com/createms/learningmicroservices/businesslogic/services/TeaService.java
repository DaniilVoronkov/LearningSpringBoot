package com.createms.learningmicroservices.businesslogic.services;


import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.stream.Collectors;

@Service
public class TeaService {

    private TeaRepository teaRepository;

    @Autowired
    public TeaService(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }

    public Iterable<Tea> getAllTea() {
        return teaRepository.findAll();
    }

    public long getAmountOfTeaProducts() {
        return teaRepository.count();
    }

    public Iterable<Tea> findByName(String name) {
        ArrayList<Tea> test = (ArrayList<Tea>) teaRepository.findAll();
         return test.stream().filter(tea -> tea.getName().equals(name)).collect(Collectors.toList());

    }

    public void saveTea(Tea tea) {
        teaRepository.save(tea);
    }

    public void deleteTea(Tea tea) {
        teaRepository.delete(tea);
    }

    public void deleteTeaById(Long id) {
        if(teaRepository.findById(id).isPresent()) {
            teaRepository.delete(teaRepository.findById(id).get());
        }
    }
}
