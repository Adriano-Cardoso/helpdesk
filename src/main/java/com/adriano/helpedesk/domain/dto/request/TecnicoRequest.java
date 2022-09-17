package com.adriano.helpedesk.domain.dto.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TecnicoRequest {

    @NotEmpty(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'nome' é obrigatório no corpo da requisição")
    @ApiModelProperty(position = 2, required = false, value = "nome do tecnico", name = "nome", dataType = "String", example = "Lucio Mauro")
    private String nome;

    @CPF
    @NotEmpty(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'cpf' é obrigatório no corpo da requisição")
    @ApiModelProperty(position = 3, required = false, value = "cpf do tecnico", name = "cpf", dataType = "String", example = "30330330333")
    private String cpf;

    @NotEmpty(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'email' é obrigatório no corpo da requisição")
    @ApiModelProperty(position = 4, required = false, value = "email do tecnico", name = "email", dataType = "String", example = "luciom@email.com")
    private String email;

    @NotEmpty(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @NotNull(message = "O valor do campo 'senha' é obrigatório no corpo da requisição")
    @ApiModelProperty(position = 5, required = false, value = "senha do tecnico", name = "senha", dataType = "String", example = "lu123")
    private String senha;

//    @Size(min = 1,  max = 4,  message = "O valor do campo 'profileId' '${validatedValue}' deve estar entre {min} e {max} caracteres")
    private Long profileId;
}
