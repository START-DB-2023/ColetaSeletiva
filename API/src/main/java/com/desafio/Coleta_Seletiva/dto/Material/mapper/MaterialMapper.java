package com.desafio.Coleta_Seletiva.dto.Material.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.desafio.Coleta_Seletiva.dto.Material.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.dto.Material.MaterialResponseDTO;
import com.desafio.Coleta_Seletiva.entities.Material.Material;

public class MaterialMapper {
  public static Material toMaterial(MaterialCreateDTO createDTO) {
    return new ModelMapper().map(createDTO, Material.class);
  }

  public static MaterialResponseDTO toDTO(Material material) {
    return new ModelMapper().map(material, MaterialResponseDTO.class);
  }

  public static List<MaterialResponseDTO> toListDTO(List<Material> materials) {
    return materials.stream().map(material -> toDTO(material)).toList();
  }
}
