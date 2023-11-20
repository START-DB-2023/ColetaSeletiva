package com.desafio.Coleta_Seletiva.material.dto;

public class MaterialDescriptionDTO {
  private String descricao;

  public MaterialDescriptionDTO() {
  }

  public MaterialDescriptionDTO(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "MaterialDescriptionDTO [descricao=" + descricao + "]";
  }

}
