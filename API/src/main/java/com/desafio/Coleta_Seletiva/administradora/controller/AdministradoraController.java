package com.desafio.Coleta_Seletiva.administradora.controller;

import java.util.List;
import java.util.stream.Collectors;
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

import com.desafio.Coleta_Seletiva.administradora.dto.AdministradoraDTO;
import com.desafio.Coleta_Seletiva.administradora.dto.mapper.AdministradoraMapper;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;
import com.desafio.Coleta_Seletiva.administradora.services.exception.AdministradoraNotFoundException;

@RestController
@RequestMapping("/api/administradoras")
public class AdministradoraController {
    @Autowired
    private AdministradoraService administradoraService;

    @Autowired
    private AdministradoraMapper administradoraMapper;

    @PostMapping
    public ResponseEntity<AdministradoraDTO> cadastrarAdministradora(@RequestBody AdministradoraDTO administradoraDTO) {
        try {
            Administradora administradora = administradoraService
                    .cadastrarAdministradora(administradoraMapper.mapToEntity(administradoraDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(administradoraMapper.mapToDTO(administradora));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<AdministradoraDTO>> listarAdministradoras() {
        try {
            List<Administradora> administradoras = administradoraService.listarAdministradoras();
            List<AdministradoraDTO> administradorasDTO = administradoras.stream()
                    .map(administradoraMapper::mapToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(administradorasDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradoraDTO> obterAdministradoraPorId(@PathVariable Long id) {
        try {
            Administradora administradora = administradoraService.obterAdministradoraPorId(id);
            return ResponseEntity.ok(administradoraMapper.mapToDTO(administradora));
        } catch (AdministradoraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<Object> desativarAdministradora(@PathVariable Long id) {
        try {
            Administradora administradoraDesativada = administradoraService.desativarAdministradora(id);
            return ResponseEntity.ok(administradoraMapper.mapToDTO(administradoraDesativada));
        } catch (AdministradoraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administradora não encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao desativar administradora: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirAdministradora(@PathVariable Long id) {
        try {
            administradoraService.excluirAdministradora(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (AdministradoraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administradora não encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir administradora: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAdministradora(
            @PathVariable Long id,
            @RequestBody AdministradoraDTO novaAdministradoraDTO) {
        try {
            Administradora novaAdministradora = administradoraMapper.mapToEntity(novaAdministradoraDTO);
            Administradora administradoraAtualizada = administradoraService.atualizarAdministradora(id,
                    novaAdministradora);
            if (administradoraAtualizada != null) {
                return ResponseEntity.ok(administradoraMapper.mapToDTO(administradoraAtualizada));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administradora não encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar administradora: " + e.getMessage());
        }
    }

}
