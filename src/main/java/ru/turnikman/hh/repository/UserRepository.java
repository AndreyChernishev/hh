package ru.turnikman.hh.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ru.turnikman.hh.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
