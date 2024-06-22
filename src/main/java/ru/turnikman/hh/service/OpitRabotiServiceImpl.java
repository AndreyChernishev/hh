package ru.turnikman.hh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.OpitRaboti;
import ru.turnikman.hh.repository.OpitRabotiRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OpitRabotiServiceImpl implements OpitRabotiService {
    private final OpitRabotiRepository opitRabotiRepository;

    @Override
    public List<OpitRaboti> getAllOpitRaboti() {
        return opitRabotiRepository.findAll();
    }

    @Override
    public OpitRaboti getOpitRabotiById(Long id) throws HhException {
        return opitRabotiRepository.findById(id).orElseThrow(() -> new HhException("getOpitRabotiById(" + id + ")"));
    }

    @Override
    public OpitRaboti addOpitRaboti(OpitRaboti opitRaboti) {
        opitRaboti.setIdOpitRaboti(null);
        return opitRabotiRepository.save(opitRaboti);
    }

    @Override
    public OpitRaboti changeOpitRabotiById(Long id, OpitRaboti opitRaboti) throws HhException {
        opitRabotiRepository.findById(id).orElseThrow(() -> new HhException("changeOpitRabotiById(" + id + ")"));
        opitRaboti.setIdOpitRaboti(id);
        return opitRabotiRepository.save(opitRaboti);
    }

    @Override
    public void deleteOpitRabotiById(Long id) throws HhException {
        opitRabotiRepository.findById(id).orElseThrow(() -> new HhException("deleteOpitRabotiById(" + id + ")"));
        opitRabotiRepository.deleteById(id);
    }
}