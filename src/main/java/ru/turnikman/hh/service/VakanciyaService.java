package ru.turnikman.hh.service;

import org.springframework.data.domain.Page;
import ru.turnikman.hh.model.Soiskatel;
import ru.turnikman.hh.model.Vakanciya;

import java.util.List;
import java.util.Optional;

public interface VakanciyaService {
    Page<Vakanciya> getAllVakanciya(int page);
    Vakanciya getVakanciyaById(Long id);
    List<Vakanciya> getVakanciyaByKlyuchevoyNavik(String klyuchevoyNavik);
    Vakanciya addVakanciya(Vakanciya vakanciya);
    Vakanciya changeVakanciyaById(Long id,Vakanciya vakanciya);
    void deleteVakanciyaById(Long id);
}
