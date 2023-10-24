package com.softwareproduct.gpmvsystem.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softwareproduct.gpmvsystem.domain.model.enums.Cargos;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contratado {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matricula;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAdmissao = LocalDate.now();
    private String registroGeral;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Cargos cargo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "contratado")
    private List<Beneficio> beneficios;
}
