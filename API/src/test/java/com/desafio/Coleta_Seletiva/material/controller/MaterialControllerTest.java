package com.desafio.Coleta_Seletiva.material.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.Coleta_Seletiva.material.services.MaterialService;

@ExtendWith(MockitoExtension.class)
public class MaterialControllerTest {

  @InjectMocks
  private MaterialController controller;

  @Mock
  private MaterialService service;

  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }
}
