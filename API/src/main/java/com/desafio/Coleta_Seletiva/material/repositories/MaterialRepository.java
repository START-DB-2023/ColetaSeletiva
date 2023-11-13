package com.desafio.Coleta_Seletiva.material.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.Coleta_Seletiva.material.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
