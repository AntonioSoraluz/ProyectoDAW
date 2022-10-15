package com.reclutamiento.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_rol_operacion")
@Data
public class RolOperacion {
	@EmbeddedId
	private RolOperacionPK rolOperacionPK;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable= false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "idOperacion", nullable = false, insertable= false, updatable = false)
	private Operacion operacion;
}
