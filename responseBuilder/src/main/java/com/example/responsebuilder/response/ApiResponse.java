package com.example.responsebuilder.response;

import com.example.responsebuilder.constantes.ApiResponseCode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.ResponseEntity;

@JsonPropertyOrder( { "error", "code", "message" ,"data", "extra" })
public class ApiResponse<T> {

    private final boolean error;
    private final int code;
    private final String message;
    private final T data;
    private final String extra;
    private ApiResponse(ApiResponseBuilder builder) {
        this.code = builder.code;
        this.error = builder.error;
        this.message = builder.message;
        this.extra = builder.extra;
        this.data = (T) builder.data;
    }

    public boolean isError() {
        return error;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public String getExtra() {
        return extra;
    }

    public static class ApiResponseBuilder<T> {
        private boolean error;
        private final int code;
        private final String message;
        private T data;
        private String extra;
        public ApiResponseBuilder(ApiResponseCode apiResponseCode){
            this.code = apiResponseCode.getCode();
            this.message = apiResponseCode.getMessage();
            this.error = (code != ApiResponseCode.SUCCESS.getCode());
        }
        public ApiResponseBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }
        public ApiResponseBuilder<T> withExtra(String extra) {
            this.extra = extra;
            return this;
        }
        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.code)
                    .body(apiResponse);
        }
    }
}
