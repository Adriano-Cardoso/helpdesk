package com.adriano.helpedesk.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteRequest {

    @NotNull(message = "O campo NOME é requerido")
    protected String nome;

    @NotNull(message = "O campo CPF é requerido")
    @CPF
    protected String cpf;

    @NotNull(message = "O campo EMAIL é requerido")
    protected String email;

    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;

    protected  Long chamadoId;

    protected Set<String> perfis = new HashSet<>();

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    protected LocalDate dataCriacao = LocalDate.now();
}
