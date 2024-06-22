package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.model.Vakanciya;
import ru.turnikman.hh.repository.VakanciyaRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VakanciyaServiceImpl implements VakanciyaService {
    private final VakanciyaRepository vakanciyaRepository;

    @Override
    public Page<Vakanciya> getAllVakanciya(int page) {
        int pageSize = 5;
        return vakanciyaRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public Vakanciya getVakanciyaById(Long id) throws HhException {
        return vakanciyaRepository.findById(id).orElseThrow(() -> new HhException("getVakanciyaById(" + id + ")"));
    }

    @Override
    public List<Vakanciya> getVakanciyaByKlyuchevoyNavik(String klyuchevoyNavik) throws HhException {
        return vakanciyaRepository.findVakanciyaByKlyuchevoyNavik(klyuchevoyNavik);
    }

    @Override
    public Vakanciya addVakanciya(Vakanciya vakanciya) {
        return vakanciyaRepository.save(vakanciya);
    }

    @Override
    public Vakanciya changeVakanciyaById(Long id, Vakanciya vakanciya) throws HhException {
        vakanciyaRepository.findById(id).orElseThrow(() -> new HhException("changeVakanciyaById(" + id + ")"));
        //vakanciya.setIdVakanciya(id);
        return vakanciyaRepository.save(vakanciya);
    }

    @Override
    public void deleteVakanciyaById(Long id) throws HhException {
        vakanciyaRepository.findById(id).orElseThrow(() -> new HhException("deleteVakanciyaById(" + id + ")"));
        vakanciyaRepository.deleteById(id);
    }
}