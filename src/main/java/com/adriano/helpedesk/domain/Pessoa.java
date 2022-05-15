package com.adriano.helpedesk.domain;

import com.adriano.helpedesk.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class Pessoa {

    private Long pessoaId;

    private String nome;

    private String cpg;

    private String email;

    private String senha;

    private Set<Integer> perfis = new HashSet<>();

    private LocalDate localDate = LocalDate.now();

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
