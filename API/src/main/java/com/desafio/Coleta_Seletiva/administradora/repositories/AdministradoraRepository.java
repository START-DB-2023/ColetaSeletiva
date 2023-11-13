package com.desafio.Coleta_Seletiva.administradora.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafio.Coleta_Seletiva.administradora.model.Administradora;

@Repository
public interface AdministradoraRepository extends JpaRepository<Administradora, Long> {
    List<Administradora> findByAtivoTrue();
}
