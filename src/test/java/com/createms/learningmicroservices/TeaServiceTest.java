package com.createms.learningmicroservices;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TeaServiceTest {


    @Mock
    TeaRepository teaRepository;

    @InjectMocks
    TeaService teaService;

    private Validator validator;


    @Test
    void contextLoads() {
        assertNotNull(teaService);
    }

    @BeforeEach
    public void setup() {
        teaRepository = Mockito.mock(TeaRepository.class);
        teaService = new TeaService(teaRepository);
    }

    @Test
    @DisplayName("Testing annotation validation")
    public void saveTeaFail() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Tea tea = new Tea("123", TeaType.LOOSE, 123.123);
        Set<ConstraintViolation<Tea>> violationSet = validator.validate(tea);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Find by id when item does not exists")
    public void findTeaByIdFail() {
        assertThrows(ResourceNotFoundException.class, () -> teaService.findById(anyLong()));
    }


    @Test
    @DisplayName("Find by id with valid argument")
    public void findByIdSuccess() {
        long productId = 1L;
        String productName = "Test Product";
        Tea testTea = new Tea(productName, TeaType.LOOSE, 123.12);
        when(teaRepository.findById(anyLong())).thenReturn(Optional.of(testTea));
        Optional<Tea> result = Optional.ofNullable(teaService.findById(productId));
        assertTrue(result.isPresent());
        assertEquals(productName, result.get().getName());
    }



}
