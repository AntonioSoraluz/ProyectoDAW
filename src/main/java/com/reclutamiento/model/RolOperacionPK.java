package com.reclutamiento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/*@Embeddable*/
@Data
public class RolOperacionPK{
	private int idRol;
	private int idOperacion;
}
