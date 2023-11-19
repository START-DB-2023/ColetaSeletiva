package com.desafio.Coleta_Seletiva.ponto_coleta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;
import com.desafio.Coleta_Seletiva.ponto_coleta.repositories.PontoColetaRepository;

import jakarta.transaction.Transactional;

@Service
public class PontoColetaService {
  @Autowired
  private PontoColetaRepository pontoColetaRepository;

  public PontoColetaService(PontoColetaRepository pontoColetaRepository) {
    this.pontoColetaRepository = pontoColetaRepository;
  }

  @Transactional
  public PontoColeta create(PontoColeta pontoColeta) {
    return pontoColetaRepository.save(pontoColeta);
  }
}
