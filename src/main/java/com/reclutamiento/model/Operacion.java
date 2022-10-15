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
	@Column(name = "idOperacion")
	private Integer idOperacion;
	
	@Column(name = "acceso")
	private String acceso;
	
	@Column(name = "idModulo")
	private Integer idModulo;
	
	@ManyToOne
	@JoinColumn(name = "idModulo", nullable = false, insertable=false, updatable=false)
	private Modulo modulo;
}
