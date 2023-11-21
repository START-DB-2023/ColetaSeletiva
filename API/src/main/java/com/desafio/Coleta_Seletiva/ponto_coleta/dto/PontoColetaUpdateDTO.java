package com.desafio.Coleta_Seletiva.ponto_coleta.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PontoColetaUpdateDTO {
  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @NotBlank
  private String horario_inicio;

  @NotBlank
  private String horario_termino;

  @NotBlank
  private String funcionamento;

  @Size(min = 1)
  private Set<Long> materiaisIds;

  public PontoColetaUpdateDTO() {
  }

  public PontoColetaUpdateDTO(String nome, String descricao, String horario_inicio,
      String horario_termino, String funcionamento, Set<Long> materiaisIds) {
    this.nome = nome;
    this.descricao = descricao;
    this.horario_inicio = horario_inicio;
    this.horario_termino = horario_termino;
    this.funcionamento = funcionamento;
    this.materiaisIds = materiaisIds;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getHorario_inicio() {
    return horario_inicio;
  }

  public void setHorario_inicio(String horario_inicio) {
    this.horario_inicio = horario_inicio;
  }

  public String getHorario_termino() {
    return horario_termino;
  }

  public void setHorario_termino(String horario_termino) {
    this.horario_termino = horario_termino;
  }

  public String getFuncionamento() {
    return funcionamento;
  }

  public void setFuncionamento(String funcionamento) {
    this.funcionamento = funcionamento;
  }

  public Set<Long> getMateriaisIds() {
    return materiaisIds;
  }

  public void setMateriaisIds(Set<Long> materiaisIds) {
    this.materiaisIds = materiaisIds;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((materiaisIds == null) ? 0 : materiaisIds.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PontoColetaUpdateDTO other = (PontoColetaUpdateDTO) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (materiaisIds == null) {
      if (other.materiaisIds != null)
        return false;
    } else if (!materiaisIds.equals(other.materiaisIds))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "PontoColetaUpdateDTO [nome=" + nome + ", descricao=" + descricao + ", horario_inicio=" + horario_inicio
        + ", horario_termino=" + horario_termino + ", funcionamento=" + funcionamento + ", materiaisIds=" + materiaisIds
        + "]";
  }

}
