package com.desafio.Coleta_Seletiva.ponto_coleta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.Coleta_Seletiva.ponto_coleta.controller.PontoColetaController;
import com.desafio.Coleta_Seletiva.ponto_coleta.services.PontoColetaService;

@ExtendWith(MockitoExtension.class)
public class PontoColetaControllerTest {

    @Mock
    private PontoColetaService pontoColetaService;

    @InjectMocks
    private PontoColetaController pontoColetaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pontoColetaController).build();
    }
}
