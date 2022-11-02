package com.adriano.helpedesk.domain.dto.response;

import com.adriano.helpedesk.domain.Profiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TecnicoResponse {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    private Set<Integer> perfis = new HashSet<>();


}
