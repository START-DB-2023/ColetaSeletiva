package com.desafio.Coleta_Seletiva.administradora.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.desafio.Coleta_Seletiva.administradora.services.exception.AdministradoraNotFoundException;

@RestController
@RequestMapping("/api/administradoras")
public class AdministradoraController {
    @Autowired
    private AdministradoraService administradoraService;

    @PostMapping
    public ResponseEntity<Object> cadastrarAdministradora(@RequestBody Administradora administradora) {
        try {
            Administradora novaAdministradora = administradoraService.cadastrarAdministradora(administradora);
            return new ResponseEntity<>(novaAdministradora, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar administradora: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> listarAdministradoras() {
        try {
            List<Administradora> administradoras = administradoraService.listarAdministradoras();
            return new ResponseEntity<>(administradoras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao listar administradoras: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterAdministradoraPorId(@PathVariable Long id) {
        try {
            Administradora administradora = administradoraService.obterAdministradoraPorId(id);
            return new ResponseEntity<>(administradora, HttpStatus.OK);
        } catch (AdministradoraNotFoundException e) {
            return new ResponseEntity<>("Instituição administradora não encontrada", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao obter instituição administradora: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<Object> desativarAdministradora(@PathVariable Long id) {
        try {
            Administradora administradoraDesativada = administradoraService.desativarAdministradora(id);
            return new ResponseEntity<>(administradoraDesativada, HttpStatus.OK);
        } catch (AdministradoraNotFoundException e) {
            return new ResponseEntity<>("Administradora não encontrada", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao desativar administradora: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirAdministradora(@PathVariable Long id) {
        try {
            administradoraService.excluirAdministradora(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AdministradoraNotFoundException e) {
            return new ResponseEntity<>("Administradora não encontrada", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir administradora: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAdministradora(
            @PathVariable Long id,
            @RequestBody Administradora novaAdministradora) {
        try {
            Administradora administradoraAtualizada = administradoraService.atualizarAdministradora(id,
                    novaAdministradora);
            if (administradoraAtualizada != null) {
                return new ResponseEntity<>(administradoraAtualizada, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Administradora não encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar administradora: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
