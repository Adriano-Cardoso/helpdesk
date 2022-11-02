package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.ClienteRequest;
import com.adriano.helpedesk.domain.dto.request.ClienteUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ClienteResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(Long pessoaId, String nome, String cpf, String email, String senha, Collection<Profiles> profiles) {
        super(pessoaId, nome, cpf, email, senha, profiles);
    }

    public Cliente() {
        super();
    }

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }


    public static Cliente of(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();

        cliente.nome = clienteRequest.getNome();
        cliente.cpf = clienteRequest.getCpf();
        cliente.email = clienteRequest.getEmail();
        cliente.senha = clienteRequest.getSenha();
        cliente.perfis = clienteRequest.getPerfis();

        return cliente;

    }


    public ClienteResponse toResponse() {
        return ClienteResponse.builder()
                .id(this.getPessoaId())
                .nome(this.getNome())
                .cpf(this.getCpf())
                .email(this.getEmail())
                .senha(this.getSenha())
                .perfis(this.getPerfis()).build();

    }

    public void update(ClienteUpdateRequest clienteRequest) {
        this.email = clienteRequest.getEmail();
    }


}
