package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.UnidadOrganica;
@Repository
public interface UnidadOrgRepository extends JpaRepository<UnidadOrganica, Integer>{

}
