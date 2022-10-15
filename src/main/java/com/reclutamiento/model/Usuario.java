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
	@Column(name = "idUser")
	private Integer idUser; 
	
	@Column(name = "nombre")
	private String nombre; 
	
	@Column(name = "email")
	private String email; 
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "idRol")
	private Integer idRol;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable=false, updatable=false)
	private Rol rol;

}
