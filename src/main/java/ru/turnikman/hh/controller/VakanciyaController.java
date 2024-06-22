package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.Vakanciya;
import ru.turnikman.hh.service.VakanciyaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vakanciya")
public class VakanciyaController {
    private final VakanciyaService vakanciyaService;

    @GetMapping
    ResponseEntity<Page<Vakanciya>> getAllVakanciya(@RequestParam int page) {
        return ResponseEntity.ok(vakanciyaService.getAllVakanciya(page));
    }
    @GetMapping("/{id}")
    ResponseEntity<Vakanciya> getVakanciyaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(vakanciyaService.getVakanciyaById(id));
    }
    @GetMapping("/kl_navik")
    ResponseEntity<List<Vakanciya>> getVakanciyaById(@RequestParam String kl_navik) {
        return ResponseEntity.ok(vakanciyaService.getVakanciyaByKlyuchevoyNavik(kl_navik));
    }
    @PostMapping
    ResponseEntity<Vakanciya> addVakanciya(@RequestBody Vakanciya vakanciya) {
        return ResponseEntity.ok(vakanciyaService.addVakanciya(vakanciya));
    }
    @PutMapping("/{id}")
    ResponseEntity<Vakanciya> changeVakanciyaById(@PathVariable("id") Long id, Vakanciya vakanciya) {
        return ResponseEntity.ok(vakanciyaService.changeVakanciyaById(id, vakanciya));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVakanciyaById(@PathVariable("id") Long id) {
        vakanciyaService.deleteVakanciyaById(id);
        return ResponseEntity.ok().build();
    }
}