package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.Profiles;
import com.adriano.helpedesk.validations.EmailValid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteRequest {

    @NotEmpty(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @Schema(description = "Nome do cliente", example = "Adriano Cardoso")
    private String nome;

    @CPF
    @NotEmpty(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @Schema(description = "CPF do cliente", example = "357.672.271-87")
    private String cpf;

    @NotEmpty(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @EmailValid
    @Schema(description = "E-mail do cliente", example = "adriano@email.com")
    private String email;

    @NotEmpty(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @Schema(description = "Senha do cliente", example = "aa1234")
    private String senha;

    @Size(min = 1, max = 5, message = "O valor do campo 'perfis' deve estar entre {min} e {max} caracteres")
    @Schema(description = "Perfis do cliente", example = "[1, 2, 3]")
    private Set<Integer> perfis = new HashSet<>();
}
