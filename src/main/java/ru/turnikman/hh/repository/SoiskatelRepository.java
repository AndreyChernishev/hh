package ru.turnikman.hh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.turnikman.hh.model.Soiskatel;

public interface SoiskatelRepository extends JpaRepository<Soiskatel,Long> {
}
