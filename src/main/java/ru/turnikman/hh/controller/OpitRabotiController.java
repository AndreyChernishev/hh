package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.OpitRaboti;
import ru.turnikman.hh.service.OpitRabotiService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/opit_raboti")
public class OpitRabotiController {
    private final OpitRabotiService opitRabotiService;

    @GetMapping
    ResponseEntity<List<OpitRaboti>> getAllOpitRaboti() {
        return ResponseEntity.ok(opitRabotiService.getAllOpitRaboti());
    }
    @GetMapping("/{id}")
    ResponseEntity<OpitRaboti> getOpitRabotiById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(opitRabotiService.getOpitRabotiById(id));
    }
    @PostMapping
    ResponseEntity<OpitRaboti> addOpitRaboti(@RequestBody OpitRaboti opitRaboti) {
        return ResponseEntity.ok(opitRabotiService.addOpitRaboti(opitRaboti));
    }
    @PutMapping("/{id}")
    ResponseEntity<OpitRaboti> changeOpitRabotiById(@PathVariable("id") Long id, OpitRaboti opitRaboti) {
        return ResponseEntity.ok(opitRabotiService.changeOpitRabotiById(id, opitRaboti));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOpitRabotiById(@PathVariable("id") Long id) {
        opitRabotiService.deleteOpitRabotiById(id);
        return ResponseEntity.ok().build();
    }
}