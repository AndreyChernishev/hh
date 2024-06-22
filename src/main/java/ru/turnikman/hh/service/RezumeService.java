package ru.turnikman.hh.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.model.Organizaciya;
import ru.turnikman.hh.model.Rezume;

import java.util.List;
import java.util.Optional;

@Service
public interface RezumeService {
    Page<Rezume> getAllRezume(int page);
    Rezume getRezumeById(Long id);
    Rezume addRezume(Rezume rezume);
    Rezume changeRezumeById(Long id,Rezume rezume);
    void deleteRezumeById(Long id);
}
