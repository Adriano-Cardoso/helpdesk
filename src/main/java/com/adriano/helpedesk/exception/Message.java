package com.adriano.helpedesk.exception;

import org.springframework.http.HttpStatus;


public enum Message {

    ID_NOT_FOUND_TECNICO("O video nao foi encontrado", HttpStatus.NOT_FOUND),
    ID_NOT_FOUND_CLIENTE("O cliente nao foi encontrado", HttpStatus.NOT_FOUND),
    ID_NOT_FOUND_CHAMADO("O chamado nao foi encontrado", HttpStatus.NOT_FOUND),
    EXISTING_CPF("O CPF digitado já existe me nossa base de dados", HttpStatus.BAD_REQUEST),
    TOKEN_ERROR("Token inválido", HttpStatus.FORBIDDEN ),
    NOT_FOT_USER_PERMISSION("Não autorizado", HttpStatus.FORBIDDEN),
    IS_PRESENT_USER("O TOKEN existe para esse usuário ", HttpStatus.BAD_REQUEST ),
    NAME_PROFILE_NOT_FOUND("Perfil não encontrado ", HttpStatus.NOT_FOUND );

    private String value;
    private String description;
    private HttpStatus statusCode;

    private Message(String value, HttpStatus statusCode) {
        this.value = value;
        this.statusCode = statusCode;
    }

    private Message(String value, String description, HttpStatus statusCode) {
        this.value = value;
        this.description = description;
        this.statusCode = statusCode;
    }

    private Message(String value) {
        this.value = value;
    }

    public String getMessage() {
        return this.value;
    }

    public HttpStatus getStatus() {
        return this.statusCode;
    }

    public String getDescription() {
        return description;
    }

    public BusinessException asBusinessException() {
        return BusinessException.builder().httpStatusCode(this.getStatus())
                .code(String.valueOf(this.getStatus().value())).message(this.getMessage())
                .description(this.getDescription()).build();
    }
}

