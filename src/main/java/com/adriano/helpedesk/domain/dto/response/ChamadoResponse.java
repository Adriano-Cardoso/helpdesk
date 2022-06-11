package com.adriano.helpedesk.domain.dto.response;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChamadoResponse {

    private Long chamadoId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    private Prioridade prioridade;

    private Status status;

    private String titulo;

    private String obeservacoes;

    private TecnicoResponse tecnicoResponse;

    private ClienteResponse clienteResponse;
}
