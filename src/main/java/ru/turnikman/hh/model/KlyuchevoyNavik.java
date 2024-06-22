package ru.turnikman.hh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
///
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "klyuchevoy_navik")
public class KlyuchevoyNavik {
    @Id
    @GeneratedValue(generator = "id_klyuchevoy_navik", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_klyuchevoy_navik", sequenceName = "id_klyuchevoy_navik", initialValue = 1, allocationSize = 1)
    @Column(name="id_kluchevoy_navik")
    private Long idKluchevoyNavik;
    @Column(name="nazvanie")
    private String nazvanie;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "klyuchevoyNavikRezumeSet")
    @JsonIgnore
    private Set<Rezume> rezumeSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "klyuchevoyNavikVakansiyaSet")
    @JsonIgnore
    private Set<Vakanciya> vakansiyaSet = new HashSet<>();
}
