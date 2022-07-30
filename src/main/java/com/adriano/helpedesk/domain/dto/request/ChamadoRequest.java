package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.enums.Perfil;
import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChamadoRequest {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    private Prioridade prioridade;

    private Status status;

    private String titulo;

    private String Obeservacoes;

    private Long tecnicoId;

    private Long clienteId;
}
