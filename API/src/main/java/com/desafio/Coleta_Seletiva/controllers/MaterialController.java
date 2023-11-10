package com.desafio.Coleta_Seletiva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.dto.Material.MaterialCreateDTO;
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
  public ResponseEntity<Material> create(@RequestBody MaterialCreateDTO materialDTO) {
    Material created = materialService.create(MaterialMapper.toMaterial(materialDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }
}
