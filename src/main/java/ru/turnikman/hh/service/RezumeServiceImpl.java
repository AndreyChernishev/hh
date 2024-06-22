package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.Rezume;
import ru.turnikman.hh.repository.RezumeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RezumeServiceImpl implements RezumeService {
    private final RezumeRepository rezumeRepository;

    @Override
    public Page<Rezume> getAllRezume(int page)
    {
        int pageSize = 5;
        return rezumeRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public Rezume getRezumeById(Long id) throws HhException {
        return rezumeRepository.findById(id).orElseThrow(() -> new HhException("getRezumeById(" + id + ")"));
    }

    @Override
    public Rezume addRezume(Rezume rezume) {
        rezume.setIdRezume(null);
        return rezumeRepository.save(rezume);
    }

    @Override
    public Rezume changeRezumeById(Long id, Rezume rezume) throws HhException {
        rezumeRepository.findById(id).orElseThrow(() -> new HhException("changeRezumeById(" + id + ")"));
        rezume.setIdRezume(id);
        return rezumeRepository.save(rezume);
    }

    @Override
    public void deleteRezumeById(Long id) throws HhException {
        rezumeRepository.findById(id).orElseThrow(() -> new HhException("deleteRezumeById(" + id + ")"));
        rezumeRepository.deleteById(id);
    }
}