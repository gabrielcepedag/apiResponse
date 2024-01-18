package com.example.responsebuilder.service;

import com.example.responsebuilder.model.Prueba;
import com.example.responsebuilder.repository.PruebaRepository;
import com.example.responsebuilder.response.ApiResponse;
import com.example.responsebuilder.response.ResponseBuilder;
import jakarta.transaction.Transactional;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class PruebaService {
    private MessageSource messageSource;
    private PruebaRepository pruebaRepository;
    private ResponseBuilder responseBuilder;

    public PruebaService(MessageSource messageSource, PruebaRepository pruebaRepository, ResponseBuilder responseBuilder) {
        this.messageSource = messageSource;
        this.pruebaRepository = pruebaRepository;
        this.responseBuilder = responseBuilder;
    }

    public ResponseEntity<ApiResponse> findAll(Locale locale) {
        ResponseEntity<ApiResponse> response;

        try{
            List<Prueba> lista = pruebaRepository.findAll();
            response = responseBuilder.buildResponse(HttpStatus.OK.value(), lista);
        }catch (Exception e){
            String message = messageSource.getMessage("error_load_db", null, locale);
            response = responseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
        }

        return response;
    }

    public ResponseEntity<ApiResponse> savePruebas(Locale locale) {
        ResponseEntity<ApiResponse> response;

        try{
            List<Prueba> pruebas = new ArrayList<>();
            pruebas.add(new Prueba("Gabriel", 21));
            pruebas.add(new Prueba("Enmannuel", 25));
            pruebas.add(new Prueba("Marifer", 20));
            pruebas.add(new Prueba("Wilson", 54));
            pruebas.add(new Prueba("Soraya", 54));
            List<Prueba> lista = pruebaRepository.saveAll(pruebas);

            String message = messageSource.getMessage("save_ok", new Object[]{Prueba.class.getSimpleName()}, locale);
            response = responseBuilder.buildResponse(HttpStatus.OK.value(), message, lista);
        }catch (Exception e){
            String message = messageSource.getMessage("error_save_db", new Object[]{Prueba.class.getSimpleName()}, locale);
            response = responseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
        }

        return response;
    }
}
