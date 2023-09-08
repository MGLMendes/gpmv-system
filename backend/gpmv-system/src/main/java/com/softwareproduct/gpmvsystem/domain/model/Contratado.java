package com.softwareproduct.gpmvsystem.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softwareproduct.gpmvsystem.domain.model.enums.Cargos;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contratado {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento;
    private String registroGeral;
    private String cpf;
    @Embedded
    private Endereco endereco;
//    @OneToOne
//    @MapsId
//    private Usuario usuario;
//    @OneToOne
//    @MapsId
//    private Folhas folhas;
    @Enumerated(EnumType.STRING)
    private Cargos cargo;
}
