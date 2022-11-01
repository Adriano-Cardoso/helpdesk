package com.adriano.helpedesk.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LoginResponse {

    @ApiModelProperty(position = 1, required = false, value = "token da requisicao usuario", name = "token", dataType = "String", example = "ahxdbchwdvcwueh873ydahdaiulnISJÇOWJ")
    private String token;

    @ApiModelProperty(position = 2, required = false, value = "type da requisicao usuario", name = "type", dataType = "String", example = "Beare Token")
    private String type;
}
