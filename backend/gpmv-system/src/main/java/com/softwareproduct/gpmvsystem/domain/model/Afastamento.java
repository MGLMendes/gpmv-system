package com.softwareproduct.gpmvsystem.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Afastamento {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;

    private String descricao;

    private LocalDate inicio;

    private LocalDate fim;

    @OneToOne
    @JoinColumn(name = "contratado_id", referencedColumnName = "id")
    private Contratado contratado;
}
