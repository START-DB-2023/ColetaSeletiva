package com.desafio.Coleta_Seletiva.material.dto.mapper;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.desafio.Coleta_Seletiva.material.dto.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.material.dto.MaterialResponseDTO;
import com.desafio.Coleta_Seletiva.material.model.Material;

public class MaterialMapper {
  public static Material toMaterial(MaterialCreateDTO createDTO) {
    return new ModelMapper().map(createDTO, Material.class);
  }

  public static MaterialResponseDTO toDTO(Material material) {
    return new ModelMapper().map(material, MaterialResponseDTO.class);
  }

  public static List<MaterialResponseDTO> toListDTO(List<Material> materials) {
    if (materials == null) {
      return Collections.emptyList(); 
    }
    return materials.stream().map(material -> toDTO(material)).toList();
  }
}
