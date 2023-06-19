package com.adriano.helpedesk.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {

    @NotNull(message = "O campo 'email' está incorreto no corpo da requisição")
    @Email(message = "Formato do campo 'email' está incorreto no corpo da requisição")
    @Schema(description = "Login do usuário", example = "admin@example.com")
    private String email;

    @NotNull(message = "O campo 'password' está incorreto no corpo da requisição")
    @NotEmpty(message = "O campo 'password' está vazio no corpo da requisição")
    @Schema(description = "Senha do usuário", example = "123456")
    private String password;
}
