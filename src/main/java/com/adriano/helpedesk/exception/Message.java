package com.adriano.helpedesk.exception;

import org.springframework.http.HttpStatus;


public enum Message {

    ID_NOT_FOUND_TECNICO("O video nao foi encontrado", HttpStatus.NOT_FOUND),
    EXISTING_CPF("O CPF digitado já existe me nossa base de dados", HttpStatus.BAD_REQUEST);

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

