package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.turnikman.hh.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> addUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        userService.addUser(username, password);
        return ResponseEntity.ok().build();
    }

}