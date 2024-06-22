package ru.turnikman.hh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turnikman.hh.model.Organizaciya;
import ru.turnikman.hh.service.OrganizaciyaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organizaciya")
public class OrganizaciyaController {
    private final OrganizaciyaService organizaciyaService;

    @GetMapping
    ResponseEntity<List<Organizaciya>> getAllOrganizaciya() {
        return ResponseEntity.ok(organizaciyaService.getAllOrganizaciya());
    }
    @GetMapping("/{id}")
    ResponseEntity<Organizaciya> getOrganizaciyaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(organizaciyaService.getOrganizaciyaById(id));
    }
    @PostMapping
    ResponseEntity<Organizaciya> addOrganizaciya(@RequestBody Organizaciya organizaciya) {
        return ResponseEntity.ok(organizaciyaService.addOrganizaciya(organizaciya));
    }
    @PutMapping("/{id}")
    ResponseEntity<Organizaciya> changeOrganizaciyaById(@PathVariable("id") Long id, Organizaciya organizaciya) {
        return ResponseEntity.ok(organizaciyaService.changeOrganizaciyaById(id, organizaciya));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOrganizaciyaById(@PathVariable("id") Long id) {
        organizaciyaService.deleteOrganizaciyaById(id);
        return ResponseEntity.ok().build();
    }
}