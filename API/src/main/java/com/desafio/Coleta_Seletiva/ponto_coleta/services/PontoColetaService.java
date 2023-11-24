package com.desafio.Coleta_Seletiva.ponto_coleta.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaUpdateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;
import com.desafio.Coleta_Seletiva.ponto_coleta.repositories.PontoColetaRepository;
import jakarta.transaction.Transactional;

@Service
public class PontoColetaService {
  @Autowired
  private PontoColetaRepository pontoColetaRepository;

  @Autowired
  private MaterialService materialService;

  public PontoColetaService(PontoColetaRepository pontoColetaRepository) {
    this.pontoColetaRepository = pontoColetaRepository;
  }

  @Transactional
  public PontoColeta create(PontoColeta pontoColeta) {
    return pontoColetaRepository.save(pontoColeta);
  }

  public List<PontoColeta> getAllPontosDeColeta() {
    return pontoColetaRepository.findAll();
  }

  public List<PontoColeta> getPontosDeColetaPorAdministradora(Long administradoraId) {
    return pontoColetaRepository.findByAdministradoraId(administradoraId);
  }

  @Transactional
  public PontoColeta update(Long id, PontoColetaUpdateDTO dto) {
    PontoColeta ponto = pontoColetaRepository.findById(id).orElseThrow();

    ponto.setNome(dto.getNome());
    ponto.setDescricao(dto.getDescricao());
    ponto.setHorario_inicio(dto.getHorario_inicio());
    ponto.setHorario_termino(dto.getHorario_termino());
    ponto.setFuncionamento(dto.getFuncionamento());
    ponto.getMateriais().clear();
    for (Long idMaterial : dto.getMateriaisIds()) {
      if (idMaterial != null) {
        Material material = materialService.findById(idMaterial);
        ponto.getMateriais().add(material);
      }
    }
    return ponto;
  }
}
