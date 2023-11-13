package com.desafio.Coleta_Seletiva.dto.Material;

public class MaterialDescriptionDTO {
  private String description;

  public MaterialDescriptionDTO() {
  }

  public MaterialDescriptionDTO(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "MaterialDescriptionDTO [description=" + description + "]";
  }

}
