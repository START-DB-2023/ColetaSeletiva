package com.desafio.Coleta_Seletiva.material.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.desafio.Coleta_Seletiva.material.dto.MaterialCreateDTO;
import com.desafio.Coleta_Seletiva.material.dto.mapper.MaterialMapper;
import com.desafio.Coleta_Seletiva.material.model.Cor;
import com.desafio.Coleta_Seletiva.material.model.Material;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
public class MaterialControllerTest {

  @InjectMocks
  private MaterialController controller;

  @Mock
  private MaterialService materialService;

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

    when(materialService.create(MaterialMapper.toMaterial(materialDTO)))
        .thenReturn(MaterialMapper.toMaterial(materialDTO));

    mockMvc.perform(post("/api/materiais")
        .contentType(MediaType.APPLICATION_JSON)
        .content(materialJSON))
        .andExpect(status().isCreated());

  }

  @Test
  public void getMaterialById_ShouldReturnMaterial() throws Exception {
    // Mockando o serviço
    long materialId = 1L;
    Material material = new Material();
    ReflectionTestUtils.setField(material, "id", materialId);
    material.setNome("Papel");
    material.setCor(Cor.AZUL);
    material.setDescricao("Descrição do papel");
    when(materialService.findById(materialId)).thenReturn(material);

    // Executando a requisição
    mockMvc.perform(get("/api/materiais/{id}", materialId))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(materialId))
        .andExpect(jsonPath("$.nome").value("Papel"))
        .andExpect(jsonPath("$.cor").value("AZUL"))
        .andExpect(jsonPath("$.descricao").value("Descrição do papel"));
  }

  @Test
  public void getAllColors_ShouldReturnListOfColors() throws Exception {
    mockMvc.perform(get("/api/materiais/cores"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray());
  }

  @Test
  public void deleteMaterial_ShouldReturnNoContent() throws Exception {
    // Mockando o serviço para retornar sucesso na exclusão
    long materialId = 1L;

    // Configurando o comportamento esperado no serviço
    doNothing().when(materialService).delete(materialId);

    mockMvc.perform(delete("/api/materiais/{id}", materialId))
        .andExpect(status().isNoContent());
  }

}
