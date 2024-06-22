package ru.turnikman.hh.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Organizaciya;
import ru.turnikman.hh.repository.OrganizaciyaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrganizaciyaServiceImplTest {

    private final OrganizaciyaRepository organizaciyaRepository =
            Mockito.mock(OrganizaciyaRepository.class);
    private final OrganizaciyaServiceImpl organizaciyaService =
            new OrganizaciyaServiceImpl(organizaciyaRepository);

    @Test
    void getAllOrganizaciya() {
    }

    @Test
    void getOrganizaciyaById() {
        Organizaciya organizaciya = new Organizaciya();
        organizaciya.setIdOrganizaciya(1L);
        organizaciya.setNazvanie("Spring");

        Organizaciya organizaciya2 = new Organizaciya();
        organizaciya2.setIdOrganizaciya(1L);
        organizaciya2.setNazvanie("Spring");

        Mockito.when(organizaciyaRepository.findById(1L))
                .thenReturn(Optional.of(organizaciya));

        assertEquals(organizaciya2,organizaciyaService.getOrganizaciyaById(1L));
    }

    @Test
    void addOrganizaciya() {
        Organizaciya organizaciya = new Organizaciya();
        organizaciya.setIdOrganizaciya(null);
        organizaciya.setNazvanie("Spring");

        Organizaciya organizaciya2 = new Organizaciya();
        organizaciya2.setIdOrganizaciya(1L);
        organizaciya2.setNazvanie("Spring");

        Organizaciya organizaciya3 = new Organizaciya();
        organizaciya3.setIdOrganizaciya(1L);
        organizaciya3.setNazvanie("Spring");

        Mockito.when(organizaciyaRepository.save(organizaciya))
                .thenReturn(organizaciya2);

        assertEquals(organizaciya3,organizaciyaService.addOrganizaciya(organizaciya));
    }

    @Test
    void changeOrganizaciyaById() {
    }

    @Test
    void deleteOrganizaciyaById() {
        Mockito.doThrow(new HhException("deleteOrganizaciyaById(9999)"))
                .when(organizaciyaRepository)
                .deleteById(1L);

        HhException thrown = assertThrows(HhException.class,
                ()->organizaciyaService.deleteOrganizaciyaById(9999L));

        assertEquals("deleteOrganizaciyaById(9999)", thrown.getMessage());
    }
}