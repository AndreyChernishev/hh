package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Organizaciya;
import ru.turnikman.hh.repository.OrganizaciyaRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrganizaciyaServiceImpl implements OrganizaciyaService {
    private final OrganizaciyaRepository organizaciyaRepository;

    @Override
    public List<Organizaciya> getAllOrganizaciya() {
        return organizaciyaRepository.findAll();
    }

    @Override
    public Organizaciya getOrganizaciyaById(Long id) throws HhException {
        return organizaciyaRepository.findById(id).orElseThrow(() -> new HhException("getOrganizaciyaById(" + id + ")"));
    }

    @Override
    public Organizaciya addOrganizaciya(Organizaciya organizaciya) {
        organizaciya.setIdOrganizaciya(null);
        return organizaciyaRepository.save(organizaciya);
    }

    @Override
    public Organizaciya changeOrganizaciyaById(Long id, Organizaciya organizaciya) throws HhException {
        organizaciyaRepository.findById(id).orElseThrow(() -> new HhException("changeOrganizaciyaById(" + id + ")"));
        organizaciya.setIdOrganizaciya(id);
        return organizaciyaRepository.save(organizaciya);
    }

    @Override
    public void deleteOrganizaciyaById(Long id) throws HhException {
        organizaciyaRepository.findById(id).orElseThrow(() -> new HhException("deleteOrganizaciyaById(" + id + ")"));
        organizaciyaRepository.deleteById(id);
    }
}