package com.example.responsebuilder.controller;

import com.example.responsebuilder.response.ApiResponse;
import com.example.responsebuilder.service.PruebaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prueba")
public class PruebaController {

    private PruebaService pruebaService;

    public PruebaController(PruebaService pruebaService) {
        this.pruebaService = pruebaService;
    }

    @RequestMapping(value = "/inyectar", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> savePruebas(){
        return pruebaService.savePruebas();
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> findAll() {
        return pruebaService.findAll();
    }
}
