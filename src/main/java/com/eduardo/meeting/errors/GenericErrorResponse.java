package com.eduardo.meeting.errors;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta de erro")
public class GenericErrorResponse {
    @Schema(description = "Código do erro", example = "400")
    private int statusCode;

    @Schema(description = "Mensagem do erro", example = "User not found.")
    private String message;

    public GenericErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
