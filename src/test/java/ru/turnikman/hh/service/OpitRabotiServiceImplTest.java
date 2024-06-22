package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.OpitRaboti;
import ru.turnikman.hh.repository.OpitRabotiRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OpitRabotiServiceImplTest {
    private final OpitRabotiRepository opitRabotiRepository =
            Mockito.mock(OpitRabotiRepository.class);
    private final OpitRabotiServiceImpl opitRabotiService =
            new OpitRabotiServiceImpl(opitRabotiRepository);

    @Test
    void getAllOpitRaboti() {
    }

    @Test
    void getOpitRabotiById() {
        OpitRaboti opitRaboti = new OpitRaboti();
        opitRaboti.setIdOpitRaboti(1L);
        opitRaboti.setDolshnost("Spring");

        OpitRaboti opitRaboti2 = new OpitRaboti();
        opitRaboti2.setIdOpitRaboti(1L);
        opitRaboti2.setDolshnost("Spring");

        Mockito.when(opitRabotiRepository.findById(1L))
                .thenReturn(Optional.of(opitRaboti));

        assertEquals(opitRaboti2,opitRabotiService.getOpitRabotiById(1L));
    }

    @Test
    void addOpitRaboti() {
        OpitRaboti opitRaboti = new OpitRaboti();
        opitRaboti.setIdOpitRaboti(null);
        opitRaboti.setDolshnost("Spring");

        OpitRaboti opitRaboti2 = new OpitRaboti();
        opitRaboti2.setIdOpitRaboti(1L);
        opitRaboti2.setDolshnost("Spring");

        OpitRaboti opitRaboti3 = new OpitRaboti();
        opitRaboti3.setIdOpitRaboti(1L);
        opitRaboti3.setDolshnost("Spring");

        Mockito.when(opitRabotiRepository.save(opitRaboti))
                .thenReturn(opitRaboti2);

        assertEquals(opitRaboti3,opitRabotiService.addOpitRaboti(opitRaboti));
    }

    @Test
    void changeOpitRabotiById() {
    }

    @Test
    void deleteOpitRabotiById() {
        Mockito.doThrow(new HhException("deleteOpitRabotiById(9999)"))
                .when(opitRabotiRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->opitRabotiService.deleteOpitRabotiById(9999L));

        assertEquals("deleteOpitRabotiById(9999)", thrown.getMessage());
    }
}