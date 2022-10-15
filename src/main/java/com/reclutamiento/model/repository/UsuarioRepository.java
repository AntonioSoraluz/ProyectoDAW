package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reclutamiento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByEmailAndPassword(String Usuario, String Password);
}
