package com.desafio.Coleta_Seletiva.ponto_coleta.dto;

import java.util.Set;

public class PontoColetaCreateDTO {
  private String nome;
  private String descricao;
  private Double latitude;
  private Double longitude;
  private String logradouro;
  private Integer numero;
  private String bairro;
  private String estado;
  private String pais;
  private String cep;
  private String horario_inicio;
  private String horario_termino;
  private String funcionamento;
  private Long administradoraId;
  private Set<Long> materiaisIds;

  public PontoColetaCreateDTO() {
  }

  public PontoColetaCreateDTO(String nome, String descricao, Double latitude, Double longitude, String logradouro,
      Integer numero, String bairro, String estado, String pais, String cep, String horario_inicio,
      String horario_termino, String funcionamento, Long administradoraId, Set<Long> materiaisIds) {
    this.nome = nome;
    this.descricao = descricao;
    this.latitude = latitude;
    this.longitude = longitude;
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.estado = estado;
    this.pais = pais;
    this.cep = cep;
    this.horario_inicio = horario_inicio;
    this.horario_termino = horario_termino;
    this.funcionamento = funcionamento;
    this.administradoraId = administradoraId;
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

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
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

  public Long getAdministradoraId() {
    return administradoraId;
  }

  public void setAdministradoraId(Long administradoraId) {
    this.administradoraId = administradoraId;
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
    result = prime * result + ((administradoraId == null) ? 0 : administradoraId.hashCode());
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
    PontoColetaCreateDTO other = (PontoColetaCreateDTO) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (administradoraId == null) {
      if (other.administradoraId != null)
        return false;
    } else if (!administradoraId.equals(other.administradoraId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "PontoColetaRequestDTO [nome=" + nome + ", descricao=" + descricao + ", latitude=" + latitude
        + ", longitude=" + longitude + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
        + ", estado=" + estado + ", pais=" + pais + ", cep=" + cep + ", horario_inicio=" + horario_inicio
        + ", horario_termino=" + horario_termino + ", funcionamento=" + funcionamento + ", administradoraId="
        + administradoraId + ", materiaisIds=" + materiaisIds + "]";
  }

}
