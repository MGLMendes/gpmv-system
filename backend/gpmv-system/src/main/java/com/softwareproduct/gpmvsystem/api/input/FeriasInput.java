package com.softwareproduct.gpmvsystem.api.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FeriasInput {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fim;
}
