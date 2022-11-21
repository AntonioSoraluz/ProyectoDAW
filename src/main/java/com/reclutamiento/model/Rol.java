package com.reclutamiento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tb_rol")
@Data
public class Rol {
	@Id
	private int id_Rol;
	private String descrip;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listUsuarios;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<RolOperacion> listRolOperacion;
}
