package com.reclutamiento.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RolOperacionPK implements Serializable{
	private int id_Rol;
	private int id_Operacion;
	
	//Crea un codigo hash unico
	@Override
	public int hashCode() {
		return Objects.hash(id_Operacion, id_Rol);
	}
	// Comprara
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolOperacionPK other = (RolOperacionPK) obj;
		return id_Operacion == other.id_Operacion && id_Rol == other.id_Rol;
	}
	
}
