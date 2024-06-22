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
@Table(name = "rezume")
public class Rezume {
    @Id
    @GeneratedValue(generator = "id_rezume", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_rezume", sequenceName = "id_rezume", initialValue = 1, allocationSize = 1)
    @Column(name="id_rezume")
    private Long idRezume;
    @Column(name="id_soiskatel")
    private Long idSoiskatel;
    @Column(name="zagolovok")
    private String zagolovok;
    @Column(name="zarplata")
    private int zarplata;
    @Column(name="zanyatost")
    private String zanyatost;
    @Column(name="grafik_raboti")
    private String grafikRaboti;
    @Column(name="reyting_rezume")
    private int reytingRezume;
    @Column(name="kolichesto_prosmotrov")
    private int kolichestoProsmotrov;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "rezume_klyuchevoy_navik",
            joinColumns = { @JoinColumn(name = "id_rezume") },
            inverseJoinColumns = { @JoinColumn(name = "id_kluchevoy_navik") })
    private Set<KlyuchevoyNavik> klyuchevoyNavikRezumeSet = new HashSet<>();
}
