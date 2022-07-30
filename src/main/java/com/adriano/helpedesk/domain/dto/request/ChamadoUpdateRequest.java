package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChamadoUpdateRequest {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    private Prioridade prioridade;

//    private Status status;

//    private String titulo;

    private String Obeservacoes;
}
