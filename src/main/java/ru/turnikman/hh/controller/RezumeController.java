package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.Rezume;
import ru.turnikman.hh.service.RezumeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rezume")
public class RezumeController {
    private final RezumeService rezumeService;

    @GetMapping
    ResponseEntity<Page<Rezume>> getAllRezume(@RequestParam int page) {
        return ResponseEntity.ok(rezumeService.getAllRezume(page));
    }
    @GetMapping("/{id}")
    ResponseEntity<Rezume> getRezumeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rezumeService.getRezumeById(id));
    }
    @PostMapping
    ResponseEntity<Rezume> addRezume(@RequestBody Rezume rezume) {
        return ResponseEntity.ok(rezumeService.addRezume(rezume));
    }
    @PutMapping("/{id}")
    ResponseEntity<Rezume> changeRezumeById(@PathVariable("id") Long id, Rezume rezume) {
        return ResponseEntity.ok(rezumeService.changeRezumeById(id, rezume));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRezumeById(@PathVariable("id") Long id) {
        rezumeService.deleteRezumeById(id);
        return ResponseEntity.ok().build();
    }
}