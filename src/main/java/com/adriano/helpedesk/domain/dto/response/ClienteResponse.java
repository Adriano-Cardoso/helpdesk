package com.adriano.helpedesk.domain.dto.response;


import com.adriano.helpedesk.domain.Profiles;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClienteResponse {

    protected Long id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Long profileId;


}
