package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.PessoaResponse;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    protected Long pessoaId;
    protected String nome;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    protected Set<String> perfis = new HashSet<String>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getDescricao());
    }


    public Pessoa(Long pessoaId, String nome, String cpf, String email, String senha) {
        super();
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        addPerfil(Perfil.CLIENTE);
    }

    public static Tecnico of(TecnicoRequest tecnicoRequest){
        Tecnico tecnico = new Tecnico();
        tecnico.nome = tecnicoRequest.getNome();
        tecnico.cpf = tecnicoRequest.getCpf();
        tecnico.email = tecnicoRequest.getEmail();
        tecnico.senha = tecnicoRequest.getSenha();

        return tecnico;
    }

    public PessoaResponse toResponse(){
        PessoaResponse pessoaResponse = new PessoaResponse();
        pessoaResponse.setPessoaId(this.pessoaId);
        pessoaResponse.setNome(this.nome);
        pessoaResponse.setCpf(this.cpf);
        pessoaResponse.setEmail(this.nome);
        pessoaResponse.setSenha(this.senha);
        pessoaResponse.setPerfis(this.perfis);


        return pessoaResponse;
    }
}
