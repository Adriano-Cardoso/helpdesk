package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        tecnico.profileId = tecnicoRequest.getProfileId();

        return tecnico;
    }

    public TecnicoResponse toResponse(Tecnico tecnico) {
        TecnicoResponse tecnicoResponse = new TecnicoResponse();
        tecnicoResponse.setId(tecnico.getPessoaId());
        tecnicoResponse.setNome(tecnico.getNome());
        tecnicoResponse.setCpf(tecnico.getCpf());
        tecnicoResponse.setEmail(tecnico.getEmail());
        tecnicoResponse.setSenha(tecnico.getSenha());
        tecnicoResponse.setProfileId(tecnico.getProfileId());

        return tecnicoResponse;
    }

    public void update(TecnicoRequest tecnicoRequest) {
        this.nome = tecnicoRequest.getNome();
        this.cpf = tecnicoRequest.getCpf();
        this.email = tecnicoRequest.getEmail();
        this.senha = tecnicoRequest.getSenha();
    }

    public void addProfile(Profiles profiles){
        this.profiles = new ArrayList<Profiles>();
        this.profileId = profiles.getProfileId();
    }


}
