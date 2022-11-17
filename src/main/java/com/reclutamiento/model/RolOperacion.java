package com.reclutamiento.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_rol_operacion")
@Data
public class RolOperacion {
	
	@EmbeddedId
	private RolOperacionPK pk;
	
	@ManyToOne
	@JoinColumn(name = "id_Rol", insertable = false, updatable = false, referencedColumnName = "id_Rol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "id_Operacion", insertable = false, updatable = false, referencedColumnName = "id_Operacion")
	private Operacion operacion;
	
}
