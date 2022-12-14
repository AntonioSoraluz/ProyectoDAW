package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.PerfilPuesto;

@Repository
public interface PerfilPuestoRepository extends JpaRepository<PerfilPuesto, Integer>{

}
