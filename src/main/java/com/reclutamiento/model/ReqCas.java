package com.reclutamiento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_req_cas")
@Data
public class ReqCas {
	@Id
	private int id_req_cas;
	private int clave_perfil;
	
	@ManyToOne
	@JoinColumn(name = "clave_perfil", insertable = false, updatable = false)
	private PerfilPuesto objPerPue;
}
