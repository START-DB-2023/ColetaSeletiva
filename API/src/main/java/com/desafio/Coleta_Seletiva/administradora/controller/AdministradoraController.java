package com.desafio.Coleta_Seletiva.administradora.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;

@RestController
@RequestMapping("/api/administradoras")
public class AdministradoraController {
    @Autowired
    private AdministradoraService administradoraService;

    @PostMapping
    public Administradora cadastrarAdministradora(@RequestBody Administradora administradora) {
        return administradoraService.cadastrarAdministradora(administradora);
    }

    @GetMapping
    public List<Administradora> listarAdministradoras() {
        return administradoraService.listarAdministradoras();
    }

    @GetMapping("/{id}")
    public Administradora obterAdministradoraPorId(@PathVariable Long id) {
        return administradoraService.obterAdministradoraPorId(id);
    }

    @PutMapping("/desativar/{id}")
    public Administradora desativarAdministradora(@PathVariable Long id) {
        return administradoraService.desativarAdministradora(id);
    }

    @DeleteMapping("/{id}")
    public void excluirAdministradora(@PathVariable Long id) {
        administradoraService.excluirAdministradora(id);
    }

}
