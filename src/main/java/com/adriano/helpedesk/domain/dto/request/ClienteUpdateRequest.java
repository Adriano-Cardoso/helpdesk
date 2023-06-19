package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.validations.EmailValid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteUpdateRequest {

    @Schema(description = "Nome do cliente", example = "Adriano Cardoso")
    private String nome;

    @CPF
    @Schema(description = "CPF do cliente", example = "357.672.271-87")
    private String cpf;

    @EmailValid
    @Schema(description = "E-mail do cliente", example = "adriano@email.com")
    private String email;

    @Schema(description = "Senha do cliente", example = "aa1234")
    private String senha;

}
