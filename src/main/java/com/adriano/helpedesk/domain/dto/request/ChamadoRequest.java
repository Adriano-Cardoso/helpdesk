package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChamadoRequest {

    @NotEmpty(message = "O valor do campo 'dataAbertura' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'dataAbertura' é obrigatório no corpo da requisição")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @ApiModelProperty(position = 1, value = "dataAbertura", name = "data de abertura", dataType = "String", example = "09/09/2022")
    private LocalDate dataAbertura;

    @NotEmpty(message = "O valor do campo 'dataFechamento' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'dataFechamento' é obrigatório no corpo da requisição")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @ApiModelProperty(position = 1, value = "dataFechamento", name = "data de fechamento", dataType = "String", example = "09/09/2022")
    private LocalDate dataFechamento;

    @NotEmpty(message = "O valor do campo 'prioridade' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'prioridade' é obrigatório no corpo da requisição")
    private Prioridade prioridade;

    @NotEmpty(message = "O valor do campo 'status' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'status' é obrigatório no corpo da requisição")
    private Status status;

    @NotEmpty(message = "O valor do campo 'titulo' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'titulo' é obrigatório no corpo da requisição")
    private String titulo;

    private String Obeservacoes;

    private Long tecnicoId;

    private Long clienteId;
}
