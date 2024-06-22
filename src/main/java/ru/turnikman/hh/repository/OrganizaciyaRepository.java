package ru.turnikman.hh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.turnikman.hh.model.Organizaciya;

public interface OrganizaciyaRepository extends JpaRepository<Organizaciya, Long> {
}
