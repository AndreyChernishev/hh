package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Soiskatel;
import ru.turnikman.hh.repository.SoiskatelRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SoiskatelServiceImpl implements SoiskatelService {
    private final SoiskatelRepository soiskatelRepository;

    @Override
    public List<Soiskatel> getAllSoiskatel() {
        return soiskatelRepository.findAll();
    }

    @Override
    public Soiskatel getSoiskatelById(Long id) throws HhException {
        return soiskatelRepository.findById(id).orElseThrow(() -> new HhException("getSoiskatelById(" + id + ")"));
    }

    @Override
    public Soiskatel addSoiskatel(Soiskatel soiskatel) {
        soiskatel.setIdSoiskatel(null);
        return soiskatelRepository.save(soiskatel);
    }

    @Override
    public Soiskatel changeSoiskatelById(Long id, Soiskatel soiskatel) throws HhException {
        soiskatelRepository.findById(id).orElseThrow(() -> new HhException("changeSoiskatelById(" + id + ")"));
        soiskatel.setIdSoiskatel(id);
        return soiskatelRepository.save(soiskatel);
    }

    @Override
    public void deleteSoiskatelById(Long id) throws HhException {
        soiskatelRepository.findById(id).orElseThrow(() -> new HhException("deleteSoiskatelById(" + id + ")"));
        soiskatelRepository.deleteById(id);
    }
}