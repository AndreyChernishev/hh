package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.Soiskatel;
import ru.turnikman.hh.service.SoiskatelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/soiskatel")
public class SoiskatelController {
    private final SoiskatelService soiskatelService;

    @GetMapping
    ResponseEntity<List<Soiskatel>> getAllSoiskatel() {
        return ResponseEntity.ok(soiskatelService.getAllSoiskatel());
    }
    @GetMapping("/{id}")
    ResponseEntity<Soiskatel> getSoiskatelById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(soiskatelService.getSoiskatelById(id));
    }
    @PostMapping
    ResponseEntity<Soiskatel> addSoiskatel(@RequestBody Soiskatel soiskatel) {
        return ResponseEntity.ok(soiskatelService.addSoiskatel(soiskatel));
    }
    @PutMapping("/{id}")
    ResponseEntity<Soiskatel> changeSoiskatelById(@PathVariable("id") Long id, Soiskatel soiskatel) {
        return ResponseEntity.ok(soiskatelService.changeSoiskatelById(id, soiskatel));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSoiskatelById(@PathVariable("id") Long id) {
        soiskatelService.deleteSoiskatelById(id);
        return ResponseEntity.ok().build();
    }
}