package ru.turnikman.hh.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.turnikman.hh.exceptions.HhException;
import ru.turnikman.hh.model.User;
import ru.turnikman.hh.model.UserAuthority;
import ru.turnikman.hh.model.UserRole;
import ru.turnikman.hh.repository.UserRepository;
import ru.turnikman.hh.repository.UserRolesRepository;

import java.util.List;
import java.util.Optional;




@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRolesRepository userRolesRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EntityManager manager;

    @Override
    public void addUser(String username, String password) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User user = userRepository.save(
                    new User()
                            .setId(null)
                            .setUsername(username)
                            .setPassword(passwordEncoder.encode(password))
                            .setLocked(false)
                            .setExpired(false)
                            .setEnabled(true)
            );
            userRolesRepository.save(new UserRole(null, UserAuthority.ADMIN, user));
        } else {
            throw new HhException("Пользователь уже существует");
        }
    }

    @Override
    public List<UserRole> getUserRole(String userName) throws HhException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(userName).orElseThrow(() -> new HhException("Пользователь не найден("+userName+")")));
        return userRolesRepository.findUserRolesByUser_Id(userOptional.get().getId());
    }

    @Override
    public UserRole setUserRole(String userName, String role) throws HhException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(userName).orElseThrow(() -> new HhException("Пользователь не найден("+userName+")")));
        UserAuthority userAuthority;
        try {
            userAuthority = UserAuthority.valueOf(role);
        }
        catch (IllegalArgumentException e) {
            throw new HhException("Роль пользователя не найдена("+userName+","+role+")");
        }
        return userRolesRepository.save(new UserRole(null, userAuthority, userOptional.get()));
    }

    @Override
    public UserRole delUserRole(String userName, String role) throws HhException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(userName).orElseThrow(() -> new HhException("Пользователь не найден("+userName+")")));
        UserAuthority userAuthority;
        try {
            userAuthority = UserAuthority.valueOf(role);
        }
        catch (IllegalArgumentException e) {
            throw new HhException("Роль пользователя не найдена("+userName+","+role+")");
        }
        UserRole userRole = userRolesRepository.findUserRoleByUserAndUserAuthority(userOptional.get(),userAuthority).orElseThrow(() -> new HhException("Пользователь не найден("+userName+")"));
        userRolesRepository.delete(userRole);
        return userRole;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
