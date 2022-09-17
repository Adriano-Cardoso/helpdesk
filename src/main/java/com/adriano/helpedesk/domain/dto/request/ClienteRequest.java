package com.adriano.helpedesk.domain.dto.request;

import com.adriano.helpedesk.domain.Profiles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    protected Long chamadoId;

//    @Size(min = 1,  max = 4,  message = "O valor do campo 'profileId' '${validatedValue}' deve estar entre {min} e {max} caracteres")
    protected Long profileId;

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    protected LocalDate dataCriacao = LocalDate.now();
}
