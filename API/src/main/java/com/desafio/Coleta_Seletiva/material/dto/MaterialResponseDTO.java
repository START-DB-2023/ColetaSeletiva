package com.desafio.Coleta_Seletiva.material.dto;

import com.desafio.Coleta_Seletiva.material.model.Cor;

public class MaterialResponseDTO {
  private long id;
  private String nome;
  private Cor cor;
  private String descricao;

  public MaterialResponseDTO() {
  }

  public MaterialResponseDTO(long id, String nome, Cor cor, String descricao) {
    this.id = id;
    this.nome = nome;
    this.cor = cor;
    this.descricao = descricao;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
    return "MaterialResponseDTO [id=" + id + ", nome=" + nome + ", cor=" + cor + ", descricao=" + descricao + "]";
  }

}
