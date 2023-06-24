package com.createms.learningmicroservices;

import com.createms.learningmicroservices.businesslogic.services.TeaService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.repositories.TeaRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TeaServiceTest {


    @Mock
    TeaRepository teaRepository;

    @InjectMocks
    TeaService teaService;


    @Test
    void contextLoads() {
    }


}
