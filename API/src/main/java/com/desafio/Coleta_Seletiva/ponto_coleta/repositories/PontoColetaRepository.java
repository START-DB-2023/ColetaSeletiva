package com.desafio.Coleta_Seletiva.ponto_coleta.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.Coleta_Seletiva.ponto_coleta.model.PontoColeta;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
    List<PontoColeta> findByAdministradoraId(Long administradoraId);
}

