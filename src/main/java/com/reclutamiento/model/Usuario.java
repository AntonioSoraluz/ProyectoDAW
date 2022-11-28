package com.reclutamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {
	@Id
	private int id_User;
	private String nombre;
	private String email;
	private String password;
	private int id_Rol;
	private int id_uo;
	
	@ManyToOne
	@JoinColumn(name = "id_Rol", insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "id_uo", insertable = false, updatable = false)
	private UnidadOrganica unidadorganica;
	
}
