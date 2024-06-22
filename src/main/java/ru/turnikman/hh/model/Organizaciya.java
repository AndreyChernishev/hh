package ru.turnikman.hh.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "organizaciya")
public class Organizaciya {
    @Id
    @GeneratedValue(generator = "id_organizaciya", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_organizaciya", sequenceName = "id_organizaciya", initialValue = 1, allocationSize = 1)
    @Column(name="id_organizaciya")
    private Long idOrganizaciya;
    @Column(name="nazvanie")
    private String nazvanie;
    @Column(name="adres")
    private String adres;
    @Column(name="telefon")
    private String telefon;
    @Column(name="schot")
    private int schot;
    @Column(name="parol")
    private String parol;

    @OneToMany(mappedBy = "idOrganizaciya", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Vakanciya> vakanciyaList;
}
