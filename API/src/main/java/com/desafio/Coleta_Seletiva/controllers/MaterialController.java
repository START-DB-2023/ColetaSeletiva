package com.desafio.Coleta_Seletiva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.dto.Material.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.dto.Material.MaterialResponseDTO;
import com.desafio.Coleta_Seletiva.dto.Material.mapper.MaterialMapper;
import com.desafio.Coleta_Seletiva.entities.Material.Material;
import com.desafio.Coleta_Seletiva.services.MaterialService;

@RestController
@RequestMapping("api/materiais")
public class MaterialController {
  @Autowired
  private MaterialService materialService;

  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @PostMapping
  public ResponseEntity<MaterialResponseDTO> create(@RequestBody MaterialCreateDTO materialDTO) {
    Material created = materialService.create(MaterialMapper.toMaterial(materialDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(MaterialMapper.toDTO(created));
  }

  @GetMapping
  public ResponseEntity<List<MaterialResponseDTO>> getAll() {
    List<Material> materials = materialService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(MaterialMapper.toListDTO(materials));
  }

  @GetMapping("/{id}")
  public ResponseEntity<MaterialResponseDTO> findById(@PathVariable long id) {
    Material material = materialService.findById(id);
    return ResponseEntity.ok().body(MaterialMapper.toDTO(material));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    materialService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
