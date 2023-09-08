package com.softwareproduct.gpmvsystem.domain.model.enums;

import lombok.Getter;


@Getter
public enum Perfil {

    ADMIN("ADMIN"),
    CONTRATADO("CONTRATADO");

    private String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }

    public Perfil toEnum(String descricao) {
        for (Perfil perfil : Perfil.values()) {
            if (perfil.getDescricao().equalsIgnoreCase(descricao)) {
                return perfil;
            }
        }
        throw new IllegalArgumentException();

    }
}
