package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.repository.KlyuchevoyNavikRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KlyuchevoyNavikServiceImpl implements KlyuchevoyNavikService {
    private final KlyuchevoyNavikRepository klyuchevoyNavikRepository;
    @Override
    public List<KlyuchevoyNavik> getAllKlyuchevoyNavik() {
        return klyuchevoyNavikRepository.findAll();
    }
    @Override
    public KlyuchevoyNavik getKlyuchevoyNavikById(Long id) throws HhException {
        return klyuchevoyNavikRepository.findById(id).orElseThrow(()->new HhException("getKlyuchevoyNavikById("+id+")"));
    }
    @Override
    public KlyuchevoyNavik addKlyuchevoyNavik(KlyuchevoyNavik klyuchevoyNavik) {
//        klyuchevoyNavik.setIdKluchevoyNavik(null);
        return klyuchevoyNavikRepository.save(klyuchevoyNavik);
    }
    @Override
    public KlyuchevoyNavik changeKlyuchevoyNavikById(Long id, KlyuchevoyNavik klyuchevoyNavik) throws HhException {
        klyuchevoyNavikRepository.findById(id).orElseThrow(()->new HhException("changeKlyuchevoyNavikById("+id+")"));
        klyuchevoyNavik.setIdKluchevoyNavik(id);
        return klyuchevoyNavikRepository.save(klyuchevoyNavik);
    }
    @Override
    public void deleteKlyuchevoyNavikById(Long id) throws HhException {
        klyuchevoyNavikRepository.findById(id).orElseThrow(()->new HhException("deleteKlyuchevoyNavikById("+id+")"));
        klyuchevoyNavikRepository.deleteById(id);
    }
}
