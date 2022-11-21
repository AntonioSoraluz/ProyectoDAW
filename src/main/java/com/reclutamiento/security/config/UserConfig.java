package com.reclutamiento.security.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reclutamiento.model.Usuario;
import com.reclutamiento.security.service.UserService;

@Service
public class UserConfig implements UserDetailsService{

	@Autowired
	private UserService servicio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Mediante el servicio se trae el Usuario 
		Usuario u = servicio.login(email);
		
		// Instancia de una ArrayList Set -> Sus valores no se repiten
		Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
		// Se agregan los roles
		rol.add(new SimpleGrantedAuthority(u.getRol().getDescrip()));
		
		//El tercer parametro requiere un GrandAutorithy
		UserDetails obj = new User(email, u.getPassword(), rol);
		
		return obj;
	}

}
