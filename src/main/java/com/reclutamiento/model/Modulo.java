package com.reclutamiento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "tb_modulo")
@Data
public class Modulo {
	@Id
	private int id_Modulo;
	private String descrip;
	
	@JsonIgnore
	@OneToMany(mappedBy = "modulo")
	private List<Operacion> listOperaciones;
}
