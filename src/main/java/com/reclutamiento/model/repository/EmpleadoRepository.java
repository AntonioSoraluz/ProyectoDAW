package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
