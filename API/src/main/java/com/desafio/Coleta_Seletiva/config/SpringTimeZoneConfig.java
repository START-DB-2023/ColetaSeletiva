package com.desafio.Coleta_Seletiva.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

//Diz ao spring que é uma classe de configuracao
@Configuration
public class SpringTimeZoneConfig {
  // Após a classe ser inicializada pelo Spring, o método construtor dela é
  // executado.
  @PostConstruct
  public void timezoneConfig() {
    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
  }
}
