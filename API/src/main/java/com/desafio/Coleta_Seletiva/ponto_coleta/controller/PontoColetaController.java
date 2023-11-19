package com.desafio.Coleta_Seletiva.ponto_coleta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaCreateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.mapper.PontoColetaMapper;
import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;
import com.desafio.Coleta_Seletiva.ponto_coleta.services.PontoColetaService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/pontos")
public class PontoColetaController {
  @Autowired
  private PontoColetaService pontoColetaService;

  @Autowired
  private AdministradoraService administradoraService;
  @Autowired
  private MaterialService materialService;

  public PontoColetaController(PontoColetaService pontoColetaService) {
    this.pontoColetaService = pontoColetaService;
  }

  @PostMapping
  public ResponseEntity<PontoColeta> create(@RequestBody PontoColetaCreateDTO dto) {
    PontoColeta created = pontoColetaService
        .create(new PontoColetaMapper(administradoraService, materialService).toPontoColeta(dto));
    return ResponseEntity.ok().body(created);
  }
}
