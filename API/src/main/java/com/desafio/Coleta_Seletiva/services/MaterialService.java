package com.desafio.Coleta_Seletiva.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.Coleta_Seletiva.entities.Material.Material;
import com.desafio.Coleta_Seletiva.repositories.MaterialRepository;

@Service
public class MaterialService {

  @Autowired
  private MaterialRepository materialRepository;

  public MaterialService(MaterialRepository materialRepository) {
    this.materialRepository = materialRepository;
  }

  public Material create(Material material) {
    return materialRepository.save(material);
  }

  @Transactional(readOnly = true)
  public List<Material> findAll() {
    return materialRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Material findById(Long id) {
    return materialRepository.findById(id).orElseThrow(() -> new RuntimeException());
  }

}
