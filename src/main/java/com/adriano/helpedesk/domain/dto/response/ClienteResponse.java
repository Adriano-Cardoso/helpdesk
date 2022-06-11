package com.adriano.helpedesk.domain.dto.response;

import com.adriano.helpedesk.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Set<String> perfis = new HashSet<>();

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteResponse toResponse(Cliente cliente) {
        return ClienteResponse.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .senha(cliente.getSenha())
                .perfis(cliente.getPerfis()).build();
    }

}
