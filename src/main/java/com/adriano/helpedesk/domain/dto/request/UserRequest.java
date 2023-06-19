package com.adriano.helpedesk.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {

    @NotEmpty(message = "O campo 'email' está incorreto no corpo da requisição")
    @Email(message = "Formato do campo 'email' está incorreto no corpo da requisição")
    @Schema(description = "Email do usuário", example = "aluno@email.com")
    private String email;

    @NotEmpty(message = "O campo 'username' está incorreto no corpo da requisição")
    @Schema(description = "Nome do usuário", example = "aluno")
    private String username;

    @NotEmpty(message = "O campo 'password' está incorreto no corpo da requisição")
    @Schema(description = "Senha do usuário", example = "123456")
    private String password;
}
