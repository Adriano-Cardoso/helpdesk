package com.adriano.helpedesk.domain.dto.response;


import com.adriano.helpedesk.domain.Chamado;
import com.adriano.helpedesk.domain.enums.Prioridade;
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

    private Integer status;

    private String titulo;

    private String observacoes;

    private Long tecnicoResponse;

    private Long clienteResponse;

    private String nomeCliente;

    private String nomeTecnico;

    public ChamadoResponse(Chamado chamado) {
        this.chamadoId = chamado.getId();
        this.dataAbertura = chamado.getDataAbertura();
        this.dataFechamento = chamado.getDataFechamento();
        this.prioridade = chamado.getPrioridade();
        this.status = chamado.getStatus().getCodigo();
        this.titulo = chamado.getTitulo();
        this.observacoes = chamado.getObservacoes();
        this.tecnicoResponse = chamado.getTecnico().getPessoaId();
        this.clienteResponse = chamado.getCliente().getPessoaId();
        this.nomeCliente = chamado.getCliente().getNome();
        this.nomeTecnico = chamado.getTecnico().getNome();
    }
}
