package com.desafio.Coleta_Seletiva.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.Coleta_Seletiva.entities.Material.Material;
import com.desafio.Coleta_Seletiva.repositories.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService {

  @Autowired
  private MaterialRepository materialRepository;

  public MaterialService(MaterialRepository materialRepository) {
    this.materialRepository = materialRepository;
  }

}
