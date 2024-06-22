package ru.turnikman.hh.service;

import ru.turnikman.hh.model.UserRole;


import java.util.List;

public interface UserService {

    void addUser(String username, String password);
    List<UserRole> getUserRole(String userName);
    UserRole setUserRole(String userName,String role);
    UserRole delUserRole(String userName,String role);
}
