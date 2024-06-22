package ru.turnikman.hh.service;

import ru.turnikman.hh.model.Rezume;
import ru.turnikman.hh.model.Soiskatel;

import java.util.List;
import java.util.Optional;

public interface SoiskatelService {
    List<Soiskatel> getAllSoiskatel();
    Soiskatel getSoiskatelById(Long id);
    Soiskatel addSoiskatel(Soiskatel soiskatel);
    Soiskatel changeSoiskatelById(Long id,Soiskatel soiskatel);
    void deleteSoiskatelById(Long id);
}
