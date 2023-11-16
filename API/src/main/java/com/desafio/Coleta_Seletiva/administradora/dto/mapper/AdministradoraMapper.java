package com.desafio.Coleta_Seletiva.administradora.dto.mapper;

import com.desafio.Coleta_Seletiva.administradora.dto.AdministradoraDTO;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;

public class AdministradoraMapper {
    public static AdministradoraDTO mapToDTO(Administradora administradora) {
        return new AdministradoraDTO(
                administradora.getId(),
                administradora.getNome(),
                administradora.getCidade(),
                administradora.getEstado(),
                administradora.getDescricao());
    }

    public static Administradora mapToEntity(AdministradoraDTO administradoraDTO) {
        return new Administradora(
                administradoraDTO.getId(),
                administradoraDTO.getNome(),
                administradoraDTO.getCidade(),
                administradoraDTO.getEstado(),
                administradoraDTO.getDescricao());
    }
}