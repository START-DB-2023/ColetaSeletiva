package com.desafio.Coleta_Seletiva.administradora.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.repositories.AdministradoraRepository;

@Service
public class AdministradoraService {

    @Autowired
    private AdministradoraRepository administradoraRepository;

    public List<Administradora> listarAdministradoras() {
        return administradoraRepository.findAll();
    }

    public Administradora cadastrarAdministradora(Administradora administradora) {
        return administradoraRepository.save(administradora);
    }

    public List<Administradora> listarAdministradorasAtivas() {
        return administradoraRepository.findByAtivoTrue();
    }

    public Administradora desativarAdministradora(Long id) {
        Administradora administradora = obterAdministradoraPorId(id);
        administradora.setAtivo(false);
        return administradoraRepository.save(administradora);
    }

    public Administradora obterAdministradoraPorId(Long id) {
        return administradoraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administradora não encontrada"));
    }
}
