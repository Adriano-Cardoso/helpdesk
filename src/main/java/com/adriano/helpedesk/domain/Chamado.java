package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.request.ChamadoUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.domain.enums.Perfil;
import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_chamado")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "data_abertura", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;

    @Column(name = "data_fechamento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @Column(name = "prioridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "observacoes", length = 200, nullable = false)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        this.dataAbertura = LocalDate.now();
    }

    public Chamado(Long id, Prioridade prioridade, Status status, String titulo, LocalDate dataFechamento,
                   String obeservacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.dataFechamento = dataFechamento;
        this.observacoes = obeservacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public static Chamado of(ChamadoRequest chamadoRequest) {
        Chamado chamado = new Chamado();
        chamado.dataFechamento = chamadoRequest.getDataFechamento();
        chamado.prioridade = chamadoRequest.getPrioridade();
        chamado.status = chamadoRequest.getStatus();
        chamado.titulo = chamadoRequest.getTitulo();
        chamado.observacoes = chamadoRequest.getObservacoes();

        return chamado;
    }

    public ChamadoResponse toResponse() {
        return ChamadoResponse.builder()
                .chamadoId(this.id)
                .dataAbertura(this.dataAbertura)
                .dataFechamento(this.dataFechamento)
                .prioridade(this.prioridade)
                .status(this.status.getCodigo())
                .titulo(this.titulo)
                .observacoes(this.getObservacoes())
                .tecnicoResponse(this.tecnico.getPessoaId())
                .clienteResponse(this.cliente.getPessoaId())
                .nomeCliente(this.cliente.getNome())
                .nomeTecnico(this.tecnico.getNome())
                .build();
    }

    public void addCliente(Cliente cliente) {
        cliente.getPerfis()
                .stream()
                .filter(perfil -> perfil.equals(Perfil.CLIENTE))
                .forEach(perfil -> this.cliente.getPessoaId().equals(tecnico.getPessoaId()));

    }

    public void addTecnico(Tecnico tecnico) {
        tecnico.getPerfis()
                .stream()
                .filter(perfil -> perfil.equals(Perfil.TECNICO))
                .forEach(perfil -> this.tecnico.getPessoaId().equals(tecnico.getPessoaId()));

    }

    public void update(ChamadoUpdateRequest chamadoUpdateRequest) {
        this.dataFechamento = chamadoUpdateRequest.getDataFechamento();
        this.prioridade = chamadoUpdateRequest.getPrioridade();
        this.observacoes = chamadoUpdateRequest.getObservacoes();
    }
}
