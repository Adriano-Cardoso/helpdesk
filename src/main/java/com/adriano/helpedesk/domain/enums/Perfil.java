package com.adriano.helpedesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Perfil {

    ADMIN(0, "ADMIN"),
    CLIENTE(1, "CLIENTE"),
    TECNICO(2, "TECNICO");

    @Getter
    private Integer codigo;
    @Getter
    private String descricao;

    public static Perfil toEnum(Perfil codigo) {
        if (codigo == null) {
            return null;
        }
        for (Perfil x : Perfil.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil Inválido");
    }
}
