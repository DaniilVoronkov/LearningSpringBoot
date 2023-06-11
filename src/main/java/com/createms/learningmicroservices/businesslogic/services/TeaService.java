package com.createms.learningmicroservices.businesslogic.services;


import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeaService {

    private final TeaRepository teaRepository;

    @Autowired
    public TeaService(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
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
    public void saveTea(Tea tea) {
        teaRepository.save(tea);
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
          teaRepository.deleteById(id);
    }

    public void deleteTeaByName(String name) {
            teaRepository.delete(teaRepository.findByName(name));
    }

    //finding the product by id
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

    //updating the tea product entry with the new value (!!! Later will be changed to query method)
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
