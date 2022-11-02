package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
@Table(name = "tb_tecnico")
public class Tecnico extends Pessoa {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> calleds = new ArrayList<>();

    public Tecnico() {

    }

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }



    public static Tecnico of(TecnicoRequest tecnicoRequest) {
        Tecnico tecnico = new Tecnico();
        tecnico.nome = tecnicoRequest.getNome();
        tecnico.cpf = tecnicoRequest.getCpf();
        tecnico.email = tecnicoRequest.getEmail();
        tecnico.senha = tecnicoRequest.getSenha();

        return tecnico;
    }

    public TecnicoResponse toResponse() {
        return TecnicoResponse.builder()
                .id(this.getPessoaId())
                .nome(this.getNome())
                .cpf(this.getCpf())
                .email(this.getEmail())
                .senha(this.getSenha())
                .perfis(this.getPerfis()).build();


    }

    public void update(TecnicoRequest tecnicoRequest) {
        this.nome = tecnicoRequest.getNome();
        this.cpf = tecnicoRequest.getCpf();
        this.email = tecnicoRequest.getEmail();
        this.senha = tecnicoRequest.getSenha();
    }

    public void addProfile(Perfil perfil){
        if (this.perfis == null){
            this.perfis = new HashSet<>();
        }
        this.perfis.add(perfil.getCodigo());
    }


}
