package ru.turnikman.hh.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "obrazovanie")
public class Obrazovanie {
    @Id
    @GeneratedValue(generator = "id_obrazovanie", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_obrazovanie", sequenceName = "id_obrazovanie", initialValue = 1, allocationSize = 1)
    @Column(name="id_obrazovanie")
    private Long idObrazovanie;
    @Column(name="id_rezume")
    private Long idRezume;
    @Column(name="uroven")
    private String uroven;
    @Column(name="uchebnoe_zavedenie")
    private String uchebnoeZavedenie;
    @Column(name="fakultet")
    private String fakultet;
    @Column(name="Specializaciya")
    private String specializaciya;
    @Column(name="god_okonchaniya")
    private Date godOkonchaniya;
}
