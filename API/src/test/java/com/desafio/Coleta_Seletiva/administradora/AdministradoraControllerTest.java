package com.desafio.Coleta_Seletiva.administradora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.desafio.Coleta_Seletiva.administradora.controller.AdministradoraController;
import com.desafio.Coleta_Seletiva.administradora.dto.AdministradoraDTO;
import com.desafio.Coleta_Seletiva.administradora.dto.mapper.AdministradoraMapper;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.services.AdministradoraService;

@ExtendWith(MockitoExtension.class)
public class AdministradoraControllerTest {
    @Mock
    private AdministradoraService administradoraService;

    @Mock
    private AdministradoraMapper administradoraMapper;

    @InjectMocks
    private AdministradoraController administradoraController;

    @Test
    public void registerAdministradora() {

        AdministradoraDTO administradoraDTO = new AdministradoraDTO();
        Administradora administradora = new Administradora();
        when(administradoraMapper.mapToEntity(any())).thenReturn(administradora);
        when(administradoraService.cadastrarAdministradora(administradora)).thenReturn(administradora);
        when(administradoraMapper.mapToDTO(administradora)).thenReturn(administradoraDTO);

        ResponseEntity<AdministradoraDTO> response = administradoraController
                .cadastrarAdministradora(administradoraDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void listAdministradoras_ShouldReturnList() {

        List<Administradora> administradoras = Arrays.asList(new Administradora(), new Administradora());
        when(administradoraService.listarAdministradoras()).thenReturn(administradoras);
        when(administradoraMapper.mapToDTO(any())).thenReturn(new AdministradoraDTO());

        ResponseEntity<List<AdministradoraDTO>> response = administradoraController.listarAdministradoras();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }
}
