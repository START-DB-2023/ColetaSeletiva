package com.desafio.Coleta_Seletiva.dto.Material;

import com.desafio.Coleta_Seletiva.entities.Material.Cor;

public class MaterialCreateDTO {
  private String nome;
  private Cor cor;
  private String descricao;

  public MaterialCreateDTO() {
  }

  public MaterialCreateDTO(String nome, Cor cor, String descricao) {
    this.nome = nome;
    this.cor = cor;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "MaterialCreateDTO [nome=" + nome + ", cor=" + cor + ", descricao=" + descricao + "]";
  }

}
