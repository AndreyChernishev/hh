package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.KlyuchevoyNavik;
import ru.turnikman.hh.service.KlyuchevoyNavikService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/klyuchevoy_navik")
public class KlyuchevoyNavikController {
    private final KlyuchevoyNavikService klyuchevoyNavikService;

    @GetMapping
    ResponseEntity<List<KlyuchevoyNavik>> getAllKlyuchevoyNavik() {
        return ResponseEntity.ok(klyuchevoyNavikService.getAllKlyuchevoyNavik());
    }
    @GetMapping("/{id}")
    ResponseEntity<KlyuchevoyNavik> getKlyuchevoyNavikById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(klyuchevoyNavikService.getKlyuchevoyNavikById(id));
    }
    @PostMapping
    ResponseEntity<KlyuchevoyNavik> addKlyuchevoyNavik(@RequestBody KlyuchevoyNavik klyuchevoyNavik) {
        return ResponseEntity.ok(klyuchevoyNavikService.addKlyuchevoyNavik(klyuchevoyNavik));
    }
    @PutMapping("/{id}")
    ResponseEntity<KlyuchevoyNavik> changeKlyuchevoyNavikById(@PathVariable("id") Long id, KlyuchevoyNavik klyuchevoyNavik) {
        return ResponseEntity.ok(klyuchevoyNavikService.changeKlyuchevoyNavikById(id, klyuchevoyNavik));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteKlyuchevoyNavikById(@PathVariable("id") Long id) {
        klyuchevoyNavikService.deleteKlyuchevoyNavikById(id);
        return ResponseEntity.ok().build();
    }
}
