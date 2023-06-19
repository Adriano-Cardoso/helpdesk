package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Data de fechamento", example = "09/09/2022")
    private LocalDate dataFechamento;

    @Schema(description = "Prioridade")
    private Prioridade prioridade;

    private String observacoes;
}
