package com.desafio.Coleta_Seletiva.ponto_coleta.dto.mapper;

import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaCreateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;

public class PontoColetaMapper {

  private AdministradoraService administradoraService;
  private MaterialService materialService;

  public PontoColetaMapper() {
  }

  public PontoColetaMapper(AdministradoraService administradoraService, MaterialService materialService) {
    this.administradoraService = administradoraService;
    this.materialService = materialService;
  }

  public PontoColeta toPontoColeta(PontoColetaCreateDTO pontoDTO) {
    Administradora administradora = administradoraService.obterAdministradoraPorId(pontoDTO.getAdministradoraId());
    PontoColeta ponto = new PontoColeta(pontoDTO.getNome(), pontoDTO.getDescricao(), pontoDTO.getLatitude(),
        pontoDTO.getLongitude(), pontoDTO.getLogradouro(), pontoDTO.getNumero(), pontoDTO.getBairro(),
        pontoDTO.getEstado(), pontoDTO.getPais(), pontoDTO.getCep(), pontoDTO.getHorario_inicio(),
        pontoDTO.getHorario_termino(), pontoDTO.getFuncionamento(), administradora);

    for (Long id : pontoDTO.getMateriaisIds()) {
      if (id != null) {
        Material material = materialService.findById(id);
        ponto.getMateriais().add(material);
      }
    }

    return ponto;
  }
}
