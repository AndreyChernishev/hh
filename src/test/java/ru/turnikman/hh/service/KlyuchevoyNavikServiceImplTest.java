package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.repository.KlyuchevoyNavikRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KlyuchevoyNavikServiceImplTest {
    private final KlyuchevoyNavikRepository klyuchevoyNavikRepository =
            Mockito.mock(KlyuchevoyNavikRepository.class);
    private final KlyuchevoyNavikServiceImpl klyuchevoyNavikService =
            new KlyuchevoyNavikServiceImpl(klyuchevoyNavikRepository);

    @Test
    void getAllKlyuchevoyNavik() {
    }

    @Test
    void getKlyuchevoyNavikById() {
        KlyuchevoyNavik klyuchevoyNavik = new KlyuchevoyNavik();
        klyuchevoyNavik.setIdKluchevoyNavik(1L);
        klyuchevoyNavik.setNazvanie("Spring");

        KlyuchevoyNavik klyuchevoyNavik2 = new KlyuchevoyNavik();
        klyuchevoyNavik2.setIdKluchevoyNavik(1L);
        klyuchevoyNavik2.setNazvanie("Spring");

        Mockito.when(klyuchevoyNavikRepository.findById(1L))
                .thenReturn(Optional.of(klyuchevoyNavik));

        assertEquals(klyuchevoyNavik2,klyuchevoyNavikService.getKlyuchevoyNavikById(1L));
    }

    @Test
    void addKlyuchevoyNavik() {
        KlyuchevoyNavik klyuchevoyNavik = new KlyuchevoyNavik();
        klyuchevoyNavik.setIdKluchevoyNavik(null);
        klyuchevoyNavik.setNazvanie("Spring");

        KlyuchevoyNavik klyuchevoyNavik2 = new KlyuchevoyNavik();
        klyuchevoyNavik2.setIdKluchevoyNavik(1L);
        klyuchevoyNavik2.setNazvanie("Spring");

        KlyuchevoyNavik klyuchevoyNavik3 = new KlyuchevoyNavik();
        klyuchevoyNavik3.setIdKluchevoyNavik(1L);
        klyuchevoyNavik3.setNazvanie("Spring");

        Mockito.when(klyuchevoyNavikRepository.save(klyuchevoyNavik))
                .thenReturn(klyuchevoyNavik2);

        assertEquals(klyuchevoyNavik3,klyuchevoyNavikService.addKlyuchevoyNavik(klyuchevoyNavik));
    }

    @Test
    void changeKlyuchevoyNavikById() {
    }

    @Test
    void deleteKlyuchevoyNavikById() {
        Mockito.doThrow(new HhException("deleteKlyuchevoyNavikById(9999)"))
                .when(klyuchevoyNavikRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->klyuchevoyNavikService.deleteKlyuchevoyNavikById(9999L));

        assertEquals("deleteKlyuchevoyNavikById(9999)", thrown.getMessage());
    }
}