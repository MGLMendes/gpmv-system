package com.softwareproduct.gpmvsystem.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Formularios {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formulario;
    @ManyToOne
    @JoinColumn(name = "folha_id")
    private Folhas folha;
}
