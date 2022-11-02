package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.validations.EmailValid;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
@Getter
@Setter
public class ClienteUpdateRequest {

    @ApiModelProperty(position = 1, required = false, value = "nome do cliente", name = "nome", dataType = "String", example = "Adriano Cardoso")
    private String nome;

    @CPF
    @ApiModelProperty(position = 2, required = false, value = "cpf do cliente", name = "cpf", dataType = "String", example = "357.672.271-87")
    private String cpf;

    @EmailValid
    @ApiModelProperty(position = 3, required = false, value = "email do cliente", name = "email", dataType = "String", example = "adriano@email.com")
    private String email;

    @ApiModelProperty(position = 4, required = false, value = "senha do cliente", name = "senha", dataType = "String", example = "aa1234")
    private String senha;


}
