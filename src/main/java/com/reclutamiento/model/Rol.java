package com.reclutamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_rol")
@Data
public class Rol {
	@Id
	@Column(name = "idRol")
	private Integer idRol;
	
	@Column(name = "descrip")
	private String descrip;
}
