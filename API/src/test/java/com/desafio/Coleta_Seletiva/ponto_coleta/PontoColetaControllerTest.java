package com.desafio.Coleta_Seletiva.ponto_coleta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.ponto_coleta.controller.PontoColetaController;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaCreateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaUpdateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;
import com.desafio.Coleta_Seletiva.ponto_coleta.services.PontoColetaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PontoColetaControllerTest {

    @Mock
    private PontoColetaService pontoColetaService;

    @Mock
    private AdministradoraService administradoraService;

    @Mock
    private MaterialService materialService;

    @InjectMocks
    private PontoColetaController pontoColetaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(pontoColetaController).build();
    }

    @AfterEach
    public void afterEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePontoColeta() throws Exception {
        PontoColetaCreateDTO pontoColetaCreateDTO = new PontoColetaCreateDTO();
        pontoColetaCreateDTO.setNome("Nome do Ponto");
        pontoColetaCreateDTO.setDescricao("Descrição do Ponto");
        pontoColetaCreateDTO.setMateriaisIds(Collections.singleton(1L));

        PontoColeta pontoColeta = new PontoColeta();
        pontoColeta.setId(1L);
        pontoColeta.setNome("Nome do Ponto");
        pontoColeta.setDescricao("Descrição do Ponto");

        when(pontoColetaService.create(any())).thenReturn(pontoColeta);

        mockMvc.perform(post("/api/pontos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(pontoColetaCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome do Ponto"))
                .andExpect(jsonPath("$.descricao").value("Descrição do Ponto"));

        verify(pontoColetaService, times(1)).create(any());
    }

    private String asJsonString(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    @Test
    public void testUpdatePontoColeta() throws Exception {
        PontoColetaUpdateDTO pontoColetaUpdateDTO = new PontoColetaUpdateDTO();
        pontoColetaUpdateDTO.setNome("Novo Nome");
        pontoColetaUpdateDTO.setDescricao("Nova Descrição");
        pontoColetaUpdateDTO.setHorario_inicio("08:00");
        pontoColetaUpdateDTO.setHorario_termino("18:00");
        pontoColetaUpdateDTO.setFuncionamento("Seg-Sex");
        pontoColetaUpdateDTO.setMateriaisIds(Collections.singleton(1L));

        PontoColeta pontoColetaAtualizado = new PontoColeta();
        pontoColetaAtualizado.setId(1L);
        pontoColetaAtualizado.setNome("Novo Nome");
        pontoColetaAtualizado.setDescricao("Nova Descrição");

        when(pontoColetaService.update(anyLong(), any())).thenReturn(pontoColetaAtualizado);

        mockMvc.perform(patch("/api/pontos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(pontoColetaUpdateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Novo Nome"))
                .andExpect(jsonPath("$.descricao").value("Nova Descrição"));

        verify(pontoColetaService, times(1)).update(anyLong(), any());
    }

    @Test
    public void testGetAllPontosDeColeta() throws Exception {
        PontoColeta pontoColeta1 = new PontoColeta();
        pontoColeta1.setId(1L);
        pontoColeta1.setNome("Ponto 1");
        pontoColeta1.setDescricao("Descrição do Ponto 1");

        PontoColeta pontoColeta2 = new PontoColeta();
        pontoColeta2.setId(2L);
        pontoColeta2.setNome("Ponto 2");
        pontoColeta2.setDescricao("Descrição do Ponto 2");

        List<PontoColeta> pontos = Arrays.asList(pontoColeta1, pontoColeta2);

        // Configuração do mock do PontoColetaService
        when(pontoColetaService.getAllPontosDeColeta()).thenReturn(pontos);

        mockMvc.perform(get("/api/pontos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome").value("Ponto 1"))
                .andExpect(jsonPath("$[1].nome").value("Ponto 2"));
    }

}
