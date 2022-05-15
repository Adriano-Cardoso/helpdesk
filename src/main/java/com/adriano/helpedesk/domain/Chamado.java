package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.enums.Prioridade;
import com.adriano.helpedesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_chamado")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id", nullable = false)
    private Long chamadoId;

    @Column(name = "data_abertura", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;

    @Column(name = "data_fechamento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @Column(name = "prioridade", nullable = false)
    private Prioridade prioridade;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "Obeservacoes", length = 200, nullable = false)
    private String Obeservacoes;

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


}
