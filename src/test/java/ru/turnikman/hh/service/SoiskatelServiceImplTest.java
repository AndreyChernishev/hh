package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Soiskatel;
import ru.turnikman.hh.repository.SoiskatelRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SoiskatelServiceImplTest {

    private final SoiskatelRepository soiskatelRepository =
            Mockito.mock(SoiskatelRepository.class);
    private final SoiskatelServiceImpl soiskatelService =
            new SoiskatelServiceImpl(soiskatelRepository);

    @Test
    void getAllSoiskatel() {
    }

    @Test
    void getSoiskatelById() {
        Soiskatel soiskatel = new Soiskatel();
        soiskatel.setIdSoiskatel(1L);
        soiskatel.setFamiliya("Spring");

        Soiskatel soiskatel2 = new Soiskatel();
        soiskatel2.setIdSoiskatel(1L);
        soiskatel2.setFamiliya("Spring");

        Mockito.when(soiskatelRepository.findById(1L))
                .thenReturn(Optional.of(soiskatel));

        assertEquals(soiskatel2,soiskatelService.getSoiskatelById(1L));
    }

    @Test
    void addSoiskatel() {
        Soiskatel soiskatel = new Soiskatel();
        soiskatel.setIdSoiskatel(null);
        soiskatel.setFamiliya("Spring");

        Soiskatel soiskatel2 = new Soiskatel();
        soiskatel2.setIdSoiskatel(1L);
        soiskatel2.setFamiliya("Spring");

        Soiskatel soiskatel3 = new Soiskatel();
        soiskatel3.setIdSoiskatel(1L);
        soiskatel3.setFamiliya("Spring");

        Mockito.when(soiskatelRepository.save(soiskatel))
                .thenReturn(soiskatel2);

        assertEquals(soiskatel3,soiskatelService.addSoiskatel(soiskatel));
    }

    @Test
    void changeSoiskatelById() {
    }

    @Test
    void deleteSoiskatelById() {
        Mockito.doThrow(new HhException("deleteSoiskatelById(9999)"))
                .when(soiskatelRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->soiskatelService.deleteSoiskatelById(9999L));

        assertEquals("deleteSoiskatelById(9999)", thrown.getMessage());
    }
}