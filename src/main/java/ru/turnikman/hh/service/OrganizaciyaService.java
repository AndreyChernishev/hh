package ru.turnikman.hh.service;

import ru.turnikman.hh.model.OpitRaboti;
import ru.turnikman.hh.model.Organizaciya;

import java.util.List;
import java.util.Optional;

public interface OrganizaciyaService {
    List<Organizaciya> getAllOrganizaciya();
    Organizaciya getOrganizaciyaById(Long id);
    Organizaciya addOrganizaciya(Organizaciya organizaciya);
    Organizaciya changeOrganizaciyaById(Long id,Organizaciya organizaciya);
    void deleteOrganizaciyaById(Long id);
}
