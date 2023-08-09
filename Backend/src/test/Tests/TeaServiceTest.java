import businesslogic.services.TeaService;
import models.enums.TeaType;
import models.repositories.TeaRepository;
import models.tables.Tea;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
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
        assertNotNull(teaService);
    }

    @BeforeEach
    public void setup() {
        teaRepository = Mockito.mock(TeaRepository.class);
        teaService = new TeaService(teaRepository);
    }

    @Test
    @DisplayName("Testing annotation validation")
    public void annotationValidation() {
        Tea tea = new Tea("123", TeaType.LOOSE, 123.123);
        Set<ConstraintViolation<Tea>> violationSet = teaService.isValid(tea);
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
        verify(teaRepository).findById(anyLong());
    }

    @Test
    @DisplayName("Deleting with null argument")
    public void deleteWithNullAsArgument() {
        assertThrows(IllegalArgumentException.class, () -> teaService.deleteTeaById(null));
    }
}
