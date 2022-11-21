package com.reclutamiento.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.Operacion;
import com.reclutamiento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//Query que devuelve el Usuario Logueado (JPQL)
	@Query("select u from Usuario u where u.email=?1")
	public Usuario iniciarSesion(String email);
	
	//Query mostrar operaciones con los moduloss
	@Query("SELECT o FROM RolOperacion op "
			+ "join op.operacion o "
			+ "where op.rol.id_Rol=?1")
	public List<Operacion> traerOperaciones(int idRol);
	
}
