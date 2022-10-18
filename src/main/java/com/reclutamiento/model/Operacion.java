package com.reclutamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_operaciones")
@Data
public class Operacion {
	@Id
	private int id_Operacion;
	private String acceso;
	private int id_Modulo;
}
