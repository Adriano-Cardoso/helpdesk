package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.enums.Perfil;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecncicoRequest {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String senha;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Getter
    @Setter
    private LocalDate dataCriacao;

    @Getter
    @Setter
    private Long chamadosId;
}
