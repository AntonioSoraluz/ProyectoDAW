package com.reclutamiento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tb_operaciones")
@Data
public class Operacion {
	@Id
	private int id_Operacion;
	private String acceso;
	private int id_Modulo;
	
	@ManyToOne
	@JoinColumn(name="id_Modulo", insertable = false, updatable = false)
	private Modulo modulo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "operacion")
	private List<RolOperacion> listRolOperacion;
}
