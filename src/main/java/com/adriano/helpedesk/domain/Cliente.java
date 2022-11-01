package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.ClienteRequest;
import com.adriano.helpedesk.domain.dto.response.ClienteResponse;
import com.adriano.helpedesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


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
        cliente.profileId = clienteRequest.getProfileId();

        return cliente;

    }

    public ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getPessoaId());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setCpf(cliente.getCpf());
        clienteResponse.setEmail(cliente.getEmail());
        clienteResponse.setSenha(cliente.getSenha());
        clienteResponse.setProfileId(cliente.getProfileId());

        return clienteResponse;
    }

    public void update(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.cpf = clienteRequest.getCpf();
        this.email = clienteRequest.getEmail();
        this.senha = clienteRequest.getSenha();
    }


}
