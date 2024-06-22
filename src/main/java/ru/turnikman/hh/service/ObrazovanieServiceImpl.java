package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Obrazovanie;
import ru.turnikman.hh.repository.ObrazovanieRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ObrazovanieServiceImpl implements ObrazovanieService {
    private final ObrazovanieRepository obrazovanieRepository;

    @Override
    public List<Obrazovanie> getAllObrazovanie() {
        return obrazovanieRepository.findAll();
    }

    @Override
    public Obrazovanie getObrazovanieById(Long id) throws HhException {
        return obrazovanieRepository.findById(id).orElseThrow(() -> new HhException("getObrazovanieById(" + id + ")"));
    }

    @Override
    public Obrazovanie addObrazovanie(Obrazovanie obrazovanie) {
        obrazovanie.setIdObrazovanie(null);
        return obrazovanieRepository.save(obrazovanie);
    }

    @Override
    public Obrazovanie changeObrazovanieById(Long id, Obrazovanie obrazovanie) throws HhException {
        obrazovanieRepository.findById(id).orElseThrow(() -> new HhException("changeObrazovanieById(" + id + ")"));
        obrazovanie.setIdObrazovanie(id);
        return obrazovanieRepository.save(obrazovanie);
    }

    @Override
    public void deleteObrazovanieById(Long id) throws HhException {
        obrazovanieRepository.findById(id).orElseThrow(() -> new HhException("deleteObrazovanieById(" + id + ")"));
        obrazovanieRepository.deleteById(id);
    }
}
