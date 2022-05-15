package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chamado {

    private Long chamadoId;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String Obeservacoes;

    private Tecnico tecnico;
    private Cliente cliente;

}
