package com.desafio.Coleta_Seletiva.ponto_coleta.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.material.model.Material;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pontos_de_coleta")
public class PontoColeta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
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

  @ManyToOne
  @JoinColumn(name = "administradora_id", nullable = false)
  private Administradora administradora;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(name = "ponto_de_coleta_materiais", joinColumns = {
      @JoinColumn(name = "ponto_de_coleta_id") }, inverseJoinColumns = { @JoinColumn(name = "material_id") })
  private Set<Material> materiais = new HashSet<Material>();

  public PontoColeta(String nome, String descricao, Double latitude, Double longitude, String logradouro,
      Integer numero, String bairro, String estado, String pais, String cep, String horario_inicio,
      String horario_termino, String funcionamento, Administradora administradora) {
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
    this.administradora = administradora;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Administradora getAdministradora() {
    return administradora;
  }

  public Set<Material> getMateriais() {
    return materiais;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
    PontoColeta other = (PontoColeta) obj;
    if (id != other.id)
      return false;
    return true;
  }

}
