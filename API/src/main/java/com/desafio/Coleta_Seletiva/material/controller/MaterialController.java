package com.desafio.Coleta_Seletiva.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.material.dto.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.material.dto.MaterialDescriptionDTO;
import com.desafio.Coleta_Seletiva.material.dto.MaterialResponseDTO;
import com.desafio.Coleta_Seletiva.material.dto.mapper.MaterialMapper;
import com.desafio.Coleta_Seletiva.material.model.Cor;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/materiais")
public class MaterialController {
  @Autowired
  private MaterialService materialService;

  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @PostMapping
  public ResponseEntity<MaterialResponseDTO> create(@Valid @RequestBody MaterialCreateDTO materialDTO) {
    Material created = materialService.create(MaterialMapper.toMaterial(materialDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(MaterialMapper.toDTO(created));
  }

  @GetMapping("/cores")
  public ResponseEntity<List<Cor>> getAllColors() {
    return ResponseEntity.ok().body(List.of(Cor.class.getEnumConstants()));
  }

  @GetMapping
  public ResponseEntity<List<MaterialResponseDTO>> getAll() {
    List<Material> materials = materialService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(MaterialMapper.toListDTO(materials));
  }

  @GetMapping("/{id}")
  public ResponseEntity<MaterialResponseDTO> findById(@Valid @PathVariable long id) {
    Material material = materialService.findById(id);
    return ResponseEntity.ok().body(MaterialMapper.toDTO(material));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@Valid @PathVariable long id) {
    materialService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<MaterialResponseDTO> updateDescription(@Valid @PathVariable long id,
      @RequestBody MaterialDescriptionDTO dto) {
    Material material = materialService.updateDescription(id, dto.getDescription());
    return ResponseEntity.ok().body(MaterialMapper.toDTO(material));
  }

}
