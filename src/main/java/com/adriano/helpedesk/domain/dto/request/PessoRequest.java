package com.adriano.helpedesk.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Nome da pessoa")
    protected String nome;

    @NotNull(message = "O campo CPF é requerido")
    @CPF
    @Schema(description = "CPF da pessoa")
    protected String cpf;

    @NotNull(message = "O campo EMAIL é requerido")
    @Schema(description = "Email da pessoa")
    protected String email;

    @NotNull(message = "O campo SENHA é requerido")
    @Schema(description = "Senha da pessoa")
    protected String senha;

    protected Long chamadoId;

    protected Set<String> perfis = new HashSet<>();
}
