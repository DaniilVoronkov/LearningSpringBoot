package com.createms.learningmicroservices.businesslogic.services;


import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
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

            teaRepository.deleteByName(name);

    }
}
