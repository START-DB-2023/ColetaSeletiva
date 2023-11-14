package com.desafio.Coleta_Seletiva.administradora.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;
import com.desafio.Coleta_Seletiva.administradora.repositories.AdministradoraRepository;
import com.desafio.Coleta_Seletiva.administradora.services.exception.AdministradoraNotFoundException;

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
                .orElseThrow(() -> new AdministradoraNotFoundException("Instituição administradora não encontrada com o ID: " + id));
    }

    public void excluirAdministradora(Long id) {
        administradoraRepository.deleteById(id);
    }

    public Administradora atualizarAdministradora(Long id, Administradora novaAdministradora) {
        Administradora administradoraExistente = obterAdministradoraPorId(id);

        if (administradoraExistente != null) {
            administradoraExistente.setNome(novaAdministradora.getNome());
            administradoraExistente.setCidade(novaAdministradora.getCidade());
            administradoraExistente.setEstado(novaAdministradora.getEstado());
            administradoraExistente.setDescricao(novaAdministradora.getDescricao());

            return administradoraRepository.save(administradoraExistente);
        } else {
            throw new AdministradoraNotFoundException("Administradora com ID " + id + " não encontrada");
        }
    }
}
