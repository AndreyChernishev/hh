package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Rezume;
import ru.turnikman.hh.repository.RezumeRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RezumeServiceImplTest {

    private final RezumeRepository rezumeRepository =
            Mockito.mock(RezumeRepository.class);
    private final RezumeServiceImpl rezumeService =
            new RezumeServiceImpl(rezumeRepository);

    @Test
    void getAllRezume() {
    }

    @Test
    void getRezumeById() {
        Rezume rezume = new Rezume();
        rezume.setIdRezume(1L);
        rezume.setZagolovok("Spring");

        Rezume rezume2 = new Rezume();
        rezume2.setIdRezume(1L);
        rezume2.setZagolovok("Spring");

        Mockito.when(rezumeRepository.findById(1L))
                .thenReturn(Optional.of(rezume));

        assertEquals(rezume2,rezumeService.getRezumeById(1L));
    }

    @Test
    void addRezume() {
        Rezume rezume = new Rezume();
        rezume.setIdRezume(null);
        rezume.setZagolovok("Spring");

        Rezume rezume2 = new Rezume();
        rezume2.setIdRezume(1L);
        rezume2.setZagolovok("Spring");

        Rezume rezume3 = new Rezume();
        rezume3.setIdRezume(1L);
        rezume3.setZagolovok("Spring");

        Mockito.when(rezumeRepository.save(rezume))
                .thenReturn(rezume2);

        assertEquals(rezume3,rezumeService.addRezume(rezume));
    }

    @Test
    void changeRezumeById() {
    }

    @Test
    void deleteRezumeById() {
        Mockito.doThrow(new HhException("deleteRezumeById(9999)"))
                .when(rezumeRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->rezumeService.deleteRezumeById(9999L));

        assertEquals("deleteRezumeById(9999)", thrown.getMessage());
    }
}