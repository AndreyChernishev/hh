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
@Table(name = "opit_raboti")
public class OpitRaboti {
    @Id
    @GeneratedValue(generator = "id_opit_raboti", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_opit_raboti", sequenceName = "id_opit_raboti", initialValue = 1, allocationSize = 1)
    @Column(name="id_opit_raboti")
    private Long idOpitRaboti;
    @Column(name="id_rezume")
    private Long idRezume;
    @Column(name="nachalo_raboti")
    private Date nachaloRaboti;
    @Column(name="okonchanie")
    private Date okonchanie;
    @Column(name="Organizaciya")
    private String organizaciya;
    @Column(name="region")
    private String region;
    @Column(name="sayt")
    private String sayt;
    @Column(name="sfera_deyatelnosti_kompanii")
    private String sferaDeyatelnostiKompanii;
    @Column(name="dolshnost")
    private String dolshnost;
    @Column(name="obyazannosti_na_rabochem_meste")
    private String obyazannostiNaRabochemMeste;
}
