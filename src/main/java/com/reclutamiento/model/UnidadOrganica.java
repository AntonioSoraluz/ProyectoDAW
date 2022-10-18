package com.reclutamiento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tb_unidad_organica")
@Data
public class UnidadOrganica {
	@Id
	private int id_uo;
	private String nom_uo; 
}
