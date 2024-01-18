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
        List<Prueba> lista = pruebaRepository.findAll();
        return responseBuilder.buildResponse(HttpStatus.OK.value(), lista);
    }

    public ResponseEntity<ApiResponse> savePruebas() {
        List<Prueba> pruebas = new ArrayList<>();
        pruebas.add(new Prueba("Gabriel", 21));
        pruebas.add(new Prueba("Enmannuel", 25));
        pruebas.add(new Prueba("Marifer", 20));
        pruebas.add(new Prueba("Wilson", 54));
        pruebas.add(new Prueba("Soraya", 54));
        List<Prueba> lista = pruebaRepository.saveAll(pruebas);
        return responseBuilder.buildResponse(HttpStatus.OK.value(), lista, "Pruebas almacenadas correctamente!");
    }
}
