package com.reclutamiento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Entity
@Table(name = "tb_perfil_puesto")
@Data
public class PerfilPuesto {
	@Id
	private int clave_perfil;
	private String nombre;
	private int id_uo;
	private String turno;
	private String descrip_perfil;
	private String estudios;
	private int edad_desde;
	private int edad_hasta;
}
