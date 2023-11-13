package com.desafio.Coleta_Seletiva.material.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.Coleta_Seletiva.exceptions.EntityNotFoundException;
import com.desafio.Coleta_Seletiva.exceptions.IntegrityViolationException;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.repositories.MaterialRepository;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class MaterialService {

  @Autowired
  private MaterialRepository materialRepository;

  public MaterialService(MaterialRepository materialRepository) {
    this.materialRepository = materialRepository;
  }

  @Transactional
  public Material create(Material material) {
    try {
      return materialRepository.save(material);
    } catch (IllegalArgumentException e) {
      throw e;
    } catch (DataIntegrityViolationException e) {
      throw new IntegrityViolationException("Violação das restrições da entidade");
    }
  }

  @Transactional(readOnly = true)
  public List<Material> findAll() {
    return materialRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Material findById(Long id) {
    return materialRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Material id: {%d} não encontrado", id)));
  }

  @Transactional
  public Material updateDescription(Long id, String description) {
    Material material = findById(id);
    material.setDescricao(description);
    return material;
  }

  @Transactional
  public void delete(Long id) {
    materialRepository.deleteById(id);
  }
}
