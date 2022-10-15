package com.reclutamiento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class RolOperacionPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idRol;
	private Integer idOperacion;
}
