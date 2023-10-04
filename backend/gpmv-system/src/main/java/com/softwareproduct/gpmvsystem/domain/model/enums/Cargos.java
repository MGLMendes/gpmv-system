package com.softwareproduct.gpmvsystem.domain.model.enums;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Getter
public enum Cargos {

    JUNIOR("JUNIOR"),
    PLENO("PLENO"),
    SENIOR("SENIOR"),
    LIDER("LIDER"),
    SCRUM_MASTER("SCRUM MASTER");


    private String cargo;

    Cargos(String cargo) {
        this.cargo = cargo;
    }

    public static Cargos toEnum(String cargo) {
        for (Cargos cargos : Cargos.values()) {
            if (cargos.getCargo().equalsIgnoreCase(cargo)) {
                return cargos;
            }
        }
        throw new IllegalArgumentException();
    }
}
