package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id", nullable = false)
    protected Long pessoaId;

    @Column(name = "nome", length = 100, nullable = false)
    protected String nome;

    @Column(unique = true)
    protected String cpf;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "senha", nullable = false)
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfis")
    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_criacao", nullable = false)
    protected LocalDate dataCriacao;


    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }

    public Pessoa(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis(Set<Perfil> perfis){
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }
}



