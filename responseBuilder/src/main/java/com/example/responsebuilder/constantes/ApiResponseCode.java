package com.example.responsebuilder.constantes;

public enum ApiResponseCode {
    SUCCESS(200, "Operación exitosa"),
    BAD_REQUEST(400, "Solicitud incorrecta"),
    NOT_FOUND(404, "Recurso no encontrado"),
    INTERNAL_SERVER_ERROR(500, "Error interno del servidor");

    private final int code;
    private final String message;

    ApiResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ApiResponseCode getByCode(int code) {
        for (ApiResponseCode responseCode : ApiResponseCode.values()) {
            if (responseCode.getCode() == code) {
                return responseCode;
            }
        }
        throw new IllegalArgumentException("Código de respuesta no válido: " + code);
    }
}
