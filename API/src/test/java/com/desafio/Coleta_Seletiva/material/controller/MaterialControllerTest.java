package com.desafio.Coleta_Seletiva.material.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.Coleta_Seletiva.material.dto.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.material.dto.mapper.MaterialMapper;
import com.desafio.Coleta_Seletiva.material.model.Cor;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  @Test
  public void createMaterial() throws Exception {
    MaterialCreateDTO materialDTO = new MaterialCreateDTO();
    materialDTO.setNome("Papel");
    materialDTO.setCor(Cor.AZUL);
    materialDTO.setDescricao(
        "Jornais, revistas, caixas, embalagens de papelão, papel de faxm sulfite, folha de caderno e envelopes");

    Material material = MaterialMapper.toMaterial(materialDTO);
    ObjectMapper objectMapper = new ObjectMapper();
    String materialJSON = objectMapper.writeValueAsString(MaterialMapper.toDTO(material));

    when(service.create(MaterialMapper.toMaterial(materialDTO))).thenReturn(MaterialMapper.toMaterial(materialDTO));

    mockMvc.perform(post("/api/materiais")
        .contentType(MediaType.APPLICATION_JSON)
        .content(materialJSON))
        .andExpect(status().isCreated());

  }
}
