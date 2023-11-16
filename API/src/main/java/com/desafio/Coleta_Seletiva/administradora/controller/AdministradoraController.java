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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Administradoras", description = "Contém todas as operações possíveis de serem realizadas com a entidade Administradora")
@RestController
@RequestMapping("/api/administradoras")
public class AdministradoraController {
    @Autowired
    private AdministradoraService administradoraService;

    @Autowired
    private AdministradoraMapper administradoraMapper;

    @Operation(description = "Cadastrar uma nova administradora")
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

    @Operation(description = "Listar todas as administradoras")
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

    @Operation(description = "Listar todas as administradoras ativas")
    @GetMapping("/ativas")
    public ResponseEntity<List<AdministradoraDTO>> listarAdministradorasAtivas() {
        try {
            List<Administradora> administradorasAtivas = administradoraService.listarAdministradorasAtivas();
            List<AdministradoraDTO> administradorasDTO = administradorasAtivas.stream()
                    .map(administradoraMapper::mapToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(administradorasDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(description = "Obter Administradora por ID")
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

    @Operation(description = "Desativar uma Administradora")
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

    @Operation(description = "Excluir uma Administradora")
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

    @Operation(description = "Atualizar uma Administradora")
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
