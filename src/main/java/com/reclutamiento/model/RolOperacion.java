package com.reclutamiento.model;

import javax.persistence.Column;
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
	@Id
	private int id_Rol_Operacion;
	private int id_Rol;
	private int id_Operacion;
}
