package com.desafio.Coleta_Seletiva.administradora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;

@RestController
@RequestMapping("/api/administradoras")
public class AdministradoraController {
    @Autowired
    private AdministradoraService administradoraService;

    @GetMapping("/{id}")
    public Administradora obterAdministradoraPorId(@PathVariable Long id) {
        return administradoraService.obterAdministradoraPorId(id);
    }
    

}
