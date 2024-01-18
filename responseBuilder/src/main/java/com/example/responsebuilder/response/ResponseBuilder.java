package com.example.responsebuilder.response;

import com.example.responsebuilder.constantes.ApiResponseCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    //Con todos
    public ResponseEntity<ApiResponse> buildResponse( int code, Object data, String extra ) {
        return new ApiResponse.ApiResponseBuilder<>(ApiResponseCode.getByCode(code))
                .withData(data)
                .withExtra(extra)
                .build();
    }

    //Sin extra
    public ResponseEntity<ApiResponse> buildResponse( int code, Object data ) {
        return new ApiResponse.ApiResponseBuilder<>(ApiResponseCode.getByCode(code))
                .withData(data)
                .build();
    }

    //Solo con el code
    public ResponseEntity<ApiResponse> buildResponse( int code ) {
        return new ApiResponse.ApiResponseBuilder<>(ApiResponseCode.getByCode(code))
               .build();
    }

    //Sin data
    public ResponseEntity<ApiResponse> buildResponse( int code, String extra ) {
        return new ApiResponse.ApiResponseBuilder<>(ApiResponseCode.getByCode(code))
                .withExtra(extra)
               .build();
    }

}
