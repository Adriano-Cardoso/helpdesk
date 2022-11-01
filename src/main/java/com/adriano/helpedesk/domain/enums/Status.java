package com.adriano.helpedesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    @Getter
    private Integer codigo;
    @Getter
    private String descricao;

    public static Status toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status Inválido");
    }
}
