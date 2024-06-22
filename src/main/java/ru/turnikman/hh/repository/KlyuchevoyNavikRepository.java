package ru.turnikman.hh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.turnikman.hh.model.KlyuchevoyNavik;

public interface KlyuchevoyNavikRepository extends JpaRepository<KlyuchevoyNavik, Long> {
}
