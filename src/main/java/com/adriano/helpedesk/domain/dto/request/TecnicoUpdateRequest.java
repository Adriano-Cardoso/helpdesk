package com.adriano.helpedesk.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TecnicoUpdateRequest {

    @NotEmpty(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @Schema(description = "Nome do técnico")
    private String nome;

    @CPF
    @NotEmpty(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @Schema(description = "CPF do técnico")
    private String cpf;

    @NotEmpty(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @Schema(description = "Email do técnico")
    private String email;

    @NotEmpty(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @Schema(description = "Senha do técnico")
    private String senha;

    @Size(min = 1, max = 4, message = "O valor do campo 'perfis' '${validatedValue}' deve estar entre {min} e {max} caracteres")
    @Schema(description = "Perfis do técnico")
    private Set<Integer> perfis = new HashSet<>();
}
