package ru.turnikman.hh.service;

import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.model.OpitRaboti;

import java.util.List;
import java.util.Optional;

public interface OpitRabotiService {
    List<OpitRaboti> getAllOpitRaboti();
    OpitRaboti getOpitRabotiById(Long id);
    OpitRaboti addOpitRaboti(OpitRaboti opitRaboti);
    OpitRaboti changeOpitRabotiById(Long id,OpitRaboti opitRaboti);
    void deleteOpitRabotiById(Long id);
}
