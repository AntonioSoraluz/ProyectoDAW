package com.reclutamiento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name = "tb_empleado")
@Data
public class Empleado {
	@Id
	private int id_empleado;
	private String nombre;
	private String apellidos;
	private String genero;
	private String direccion;
	private String telefono;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fecha_registro;
	private int id_uo;
	
	@ManyToOne
	@JoinColumn(name = "id_uo", insertable = false, updatable = false)
	private UnidadOrganica objUniOrg;
}
