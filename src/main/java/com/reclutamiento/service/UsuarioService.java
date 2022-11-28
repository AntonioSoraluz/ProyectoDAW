package com.reclutamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reclutamiento.model.Operacion;
import com.reclutamiento.model.Usuario;
import com.reclutamiento.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario login(String email, String clave) {
	    return repo.iniciarSesion(email, clave);
	  }
	  
	  public List<Operacion> modulosPorUsuario(int idRol){
	    return repo.traerOperaciones(idRol);
	  }
}
