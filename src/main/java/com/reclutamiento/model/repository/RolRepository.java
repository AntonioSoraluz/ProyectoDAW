package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
