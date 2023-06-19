package com.adriano.helpedesk.domain.dto.response;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserResponse {


//    @ApiModelProperty(position = 1, required = false, value = "email do usuario", name = "email", dataType = "String", example = "aluno@email.com")
    private String email;

//    @ApiModelProperty(position = 2, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "123456")
    private String username;
}
