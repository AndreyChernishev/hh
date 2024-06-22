package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Obrazovanie;
import ru.turnikman.hh.repository.ObrazovanieRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ObrazovanieServiceImplTest {

    private final ObrazovanieRepository obrazovanieRepository =
            Mockito.mock(ObrazovanieRepository.class);
    private final ObrazovanieServiceImpl obrazovanieService =
            new ObrazovanieServiceImpl(obrazovanieRepository);

    @Test
    void getAllObrazovanie() {
    }

    @Test
    void getObrazovanieById() {
        Obrazovanie obrazovanie = new Obrazovanie();
        obrazovanie.setIdObrazovanie(1L);
        obrazovanie.setUchebnoeZavedenie("Spring");

        Obrazovanie obrazovanie2 = new Obrazovanie();
        obrazovanie2.setIdObrazovanie(1L);
        obrazovanie2.setUchebnoeZavedenie("Spring");

        Mockito.when(obrazovanieRepository.findById(1L))
                .thenReturn(Optional.of(obrazovanie));

        assertEquals(obrazovanie2,obrazovanieService.getObrazovanieById(1L));
    }

    @Test
    void addObrazovanie() {
        Obrazovanie obrazovanie = new Obrazovanie();
        obrazovanie.setIdObrazovanie(null);
        obrazovanie.setUchebnoeZavedenie("Spring");

        Obrazovanie obrazovanie2 = new Obrazovanie();
        obrazovanie2.setIdObrazovanie(1L);
        obrazovanie2.setUchebnoeZavedenie("Spring");

        Obrazovanie obrazovanie3 = new Obrazovanie();
        obrazovanie3.setIdObrazovanie(1L);
        obrazovanie3.setUchebnoeZavedenie("Spring");

        Mockito.when(obrazovanieRepository.save(obrazovanie))
                .thenReturn(obrazovanie2);

        assertEquals(obrazovanie3,obrazovanieService.addObrazovanie(obrazovanie));
    }

    @Test
    void changeObrazovanieById() {
    }

    @Test
    void deleteObrazovanieById() {
        Mockito.doThrow(new HhException("deleteObrazovanieById(9999)"))
                .when(obrazovanieRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->obrazovanieService.deleteObrazovanieById(9999L));

        assertEquals("deleteObrazovanieById(9999)", thrown.getMessage());
    }
}