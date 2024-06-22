package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.Obrazovanie;
import ru.turnikman.hh.service.ObrazovanieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/obrazovanie")
public class ObrazovanieController {
    private final ObrazovanieService obrazovanieService;

    @GetMapping
    ResponseEntity<List<Obrazovanie>> getAllObrazovanie() {
        return ResponseEntity.ok(obrazovanieService.getAllObrazovanie());
    }
    @GetMapping("/{id}")
    ResponseEntity<Obrazovanie> getObrazovanieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(obrazovanieService.getObrazovanieById(id));
    }
    @PostMapping
    ResponseEntity<Obrazovanie> addObrazovanie(@RequestBody Obrazovanie obrazovanie) {
        return ResponseEntity.ok(obrazovanieService.addObrazovanie(obrazovanie));
    }
    @PutMapping("/{id}")
    ResponseEntity<Obrazovanie> changeObrazovanieById(@PathVariable("id") Long id, Obrazovanie obrazovanie) {
        return ResponseEntity.ok(obrazovanieService.changeObrazovanieById(id, obrazovanie));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteObrazovanieById(@PathVariable("id") Long id) {
        obrazovanieService.deleteObrazovanieById(id);
        return ResponseEntity.ok().build();
    }
}