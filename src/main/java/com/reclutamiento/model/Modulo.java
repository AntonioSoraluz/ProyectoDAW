package com.reclutamiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_modulo")
@Data
public class Modulo {
	@Id
	private int id_Modulo;
	private String descrip;
}
