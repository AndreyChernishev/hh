package ru.turnikman.hh.service;

import ru.turnikman.hh.model.KlyuchevoyNavik;

import java.util.List;

public interface KlyuchevoyNavikService {
    List<KlyuchevoyNavik> getAllKlyuchevoyNavik();
    KlyuchevoyNavik getKlyuchevoyNavikById(Long id);
    KlyuchevoyNavik addKlyuchevoyNavik(KlyuchevoyNavik klyuchevoyNavik);
    KlyuchevoyNavik changeKlyuchevoyNavikById(Long id,KlyuchevoyNavik klyuchevoyNavik);
    void deleteKlyuchevoyNavikById(Long id);
}
