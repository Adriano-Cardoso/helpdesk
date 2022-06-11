package com.adriano.helpedesk.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoRequest {

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

}
