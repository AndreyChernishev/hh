package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Vakanciya;
import ru.turnikman.hh.repository.VakanciyaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VakanciyaServiceImplTest {

    private final VakanciyaRepository vakanciyaRepository =
            Mockito.mock(VakanciyaRepository.class);
    private final VakanciyaServiceImpl vakanciyaService =
            new VakanciyaServiceImpl(vakanciyaRepository);

    @Test
    void getAllVakanciya() {
    }

    @Test
    void getVakanciyaById() {
        Vakanciya vakanciya = new Vakanciya();
        vakanciya.setIdVakansiya(1L);
        vakanciya.setDolzhnost("Spring");

        Vakanciya vakanciya2 = new Vakanciya();
        vakanciya2.setIdVakansiya(1L);
        vakanciya2.setDolzhnost("Spring");

        Mockito.when(vakanciyaRepository.findById(1L))
                .thenReturn(Optional.of(vakanciya));

        assertEquals(vakanciya2,vakanciyaService.getVakanciyaById(1L));
    }

    @Test
    void addVakanciya() {
        Vakanciya vakanciya = new Vakanciya();
        vakanciya.setIdVakansiya(null);
        vakanciya.setDolzhnost("Spring");

        Vakanciya vakanciya2 = new Vakanciya();
        vakanciya2.setIdVakansiya(1L);
        vakanciya2.setDolzhnost("Spring");

        Vakanciya vakanciya3 = new Vakanciya();
        vakanciya3.setIdVakansiya(1L);
        vakanciya3.setDolzhnost("Spring");

        Mockito.when(vakanciyaRepository.save(vakanciya))
                .thenReturn(vakanciya2);

        assertEquals(vakanciya3,vakanciyaService.addVakanciya(vakanciya));
    }

    @Test
    void changeVakanciyaById() {
    }

    @Test
    void deleteVakanciyaById() {
        Mockito.doThrow(new HhException("deleteVakanciyaById(9999)"))
                .when(vakanciyaRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->vakanciyaService.deleteVakanciyaById(9999L));

        assertEquals("deleteVakanciyaById(9999)", thrown.getMessage());
    }
}