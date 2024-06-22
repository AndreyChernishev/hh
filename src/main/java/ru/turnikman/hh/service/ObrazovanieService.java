package ru.turnikman.hh.service;

import org.springframework.stereotype.Service;
import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.model.Obrazovanie;

import java.util.List;
import java.util.Optional;

public interface ObrazovanieService {
    List<Obrazovanie> getAllObrazovanie();
    Obrazovanie getObrazovanieById(Long id);
    Obrazovanie addObrazovanie(Obrazovanie obrazovanie);
    Obrazovanie changeObrazovanieById(Long id,Obrazovanie obrazovanie);
    void deleteObrazovanieById(Long id);
}
