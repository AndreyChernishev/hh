package ru.turnikman.hh.repository;

import org.springframework.data.repository.CrudRepository;
import ru.turnikman.hh.model.User;
import ru.turnikman.hh.model.UserAuthority;
import ru.turnikman.hh.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findUserRolesByUser_Id(Long userId);
    Optional<UserRole> findUserRoleByUserAndUserAuthority(User user, UserAuthority userAuthority);
}
