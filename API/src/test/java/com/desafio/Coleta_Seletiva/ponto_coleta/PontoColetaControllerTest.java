package com.desafio.Coleta_Seletiva.ponto_coleta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;
import com.desafio.Coleta_Seletiva.material.services.MaterialService;
import com.desafio.Coleta_Seletiva.ponto_coleta.controller.PontoColetaController;
import com.desafio.Coleta_Seletiva.ponto_coleta.dto.PontoColetaCreateDTO;
import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;
import com.desafio.Coleta_Seletiva.ponto_coleta.services.PontoColetaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

import java.util.Collections;

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

}
