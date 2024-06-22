package ru.turnikman.hh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "vakanciya")
public class Vakanciya {
    @Id
    @GeneratedValue(generator = "id_vakansiya", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_vakansiya", sequenceName = "id_vakansiya", initialValue = 1, allocationSize = 1)
    @Column(name="id_vakansiya")
    private Long idVakansiya;
//    @Column(name="id_organizaciya")
//    private Long idOrganizaciya;
    @Column(name="zagolovok")
    private String zagolovok;
    @Column(name="dolzhnost")
    private String dolzhnost;
    @Column(name="oklad_min")
    private int okladMin;
    @Column(name="oklad_max")
    private int okladMax;
    @Column(name="opit_raboti_min")
    private int opitRabotiMin;
    @Column(name="opit_raboti_max")
    private int opitRabotiMax;
    @Column(name="zanyatost")
    private String zanyatost;
    @Column(name="vozrast_min")
    private int vozrastMin;
    @Column(name="vozrast_max")
    private int vozrastMax;
    @Column(name="pol")
    private String pol;
    @Column(name="zadachi")
    private String zadachi;
    @Column(name="trebovaniya")
    private String trebovaniya;
    @Column(name="usloviya")
    private String usloviya;
    @Column(name="kolichestvo_prosmotrov")
    private int kolichestvoProsmotrov;
    @Column(name="oplachena")
    private boolean oplachena;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "vakanciya_klyuchevoy_navik",
            joinColumns = { @JoinColumn(name = "id_vakansiya") },
            inverseJoinColumns = { @JoinColumn(name = "id_kluchevoy_navik") })
    private Set<KlyuchevoyNavik> klyuchevoyNavikVakansiyaSet = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_organizaciya")
    private Organizaciya idOrganizaciya;
}
