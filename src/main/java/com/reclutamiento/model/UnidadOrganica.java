package com.reclutamiento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="tb_unidad_organica")
@Data
public class UnidadOrganica {
	@Id
	private int id_uo;
	private String nom_uo;
	private String nom_jefe_uni_Org;
	
	@JsonIgnore
	@OneToMany(mappedBy = "unidadorganica")
	private List<Usuario> listUsuarios;
	
}
