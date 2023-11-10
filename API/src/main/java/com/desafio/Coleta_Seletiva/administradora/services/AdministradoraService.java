package com.desafio.Coleta_Seletiva.administradora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void excluirAdministradora(Long id) {
        administradoraRepository.deleteById(id);
    }
    //falta alguns métodos ainda
}
