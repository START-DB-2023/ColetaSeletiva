package com.desafio.Coleta_Seletiva.dto.Material.mapper;

import org.modelmapper.ModelMapper;

import com.desafio.Coleta_Seletiva.dto.Material.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.entities.Material.Material;

public class MaterialMapper {
  public static Material toMaterial(MaterialCreateDTO createDTO) {
    return new ModelMapper().map(createDTO, Material.class);
  }
}
