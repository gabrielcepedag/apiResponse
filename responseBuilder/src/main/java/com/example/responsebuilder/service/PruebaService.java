package com.example.responsebuilder.service;

import com.example.responsebuilder.model.Prueba;
import com.example.responsebuilder.repository.PruebaRepository;
import com.example.responsebuilder.response.ApiResponse;
import com.example.responsebuilder.response.ResponseBuilder;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PruebaService {
    private PruebaRepository pruebaRepository;
    private ResponseBuilder responseBuilder;

    public PruebaService(PruebaRepository pruebaRepository, ResponseBuilder responseBuilder) {
        this.pruebaRepository = pruebaRepository;
        this.responseBuilder = responseBuilder;
    }

    public ResponseEntity<ApiResponse> findAll() {
        ResponseEntity<ApiResponse> response;

        try{
            List<Prueba> lista = pruebaRepository.findAll();
            response = responseBuilder.buildResponse(HttpStatus.OK.value(), lista);
        }catch (Exception e){
            response = responseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al cargar Base de Datos");
        }

        return response;
    }

    public ResponseEntity<ApiResponse> savePruebas() {
        ResponseEntity<ApiResponse> response;

        try{
            List<Prueba> pruebas = new ArrayList<>();
            pruebas.add(new Prueba("Gabriel", 21));
            pruebas.add(new Prueba("Enmannuel", 25));
            pruebas.add(new Prueba("Marifer", 20));
            pruebas.add(new Prueba("Wilson", 54));
            pruebas.add(new Prueba("Soraya", 54));
            List<Prueba> lista = pruebaRepository.saveAll(pruebas);
            response = responseBuilder.buildResponse(HttpStatus.OK.value(), "Pruebas almacenadas correctamente!", lista);
        }catch (Exception e){
            response = responseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al guardar las Pruebas!");
        }

        return response;
    }
}
