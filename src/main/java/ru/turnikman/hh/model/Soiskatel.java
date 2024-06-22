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
@Table(name = "soiskatel")
public class Soiskatel {
    @Id
    @GeneratedValue(generator = "id_soiskatel", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_soiskatel", sequenceName = "id_soiskatel", initialValue = 1, allocationSize = 1)
    @Column(name="id_soiskatel")
    private Long idSoiskatel;
    @Column(name="familiya")
    private String familiya;
    @Column(name="imya")
    private String imya;
    @Column(name="otchestvo")
    private String otchestvo;
    @Column(name="pol")
    private String pol;
    @Column(name="data_roshdeniya")
    private Date dataRoshdeniya;
    @Column(name="region")
    private String region;
    @Column(name="telefon")
    private String telefon;
    @Column(name="email")
    private String email;
    @Column(name="grazhdanstvo")
    private String grazhdanstvo;
    @Column(name="rasreshenie_na_rabotu_strana")
    private String rasreshenieNaRabotuStrana;
    @Column(name="uroven_obrazovaniya")
    private String urovenObrazovaniya;
    @Column(name="OpitRaboti")
    private String opitRaboti;
    @Column(name="parol")
    private String parol;
}
