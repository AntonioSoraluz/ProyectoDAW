package com.reclutamiento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_proveedores")
public class Proveedor {
	
	
    @Id
	private int cod_Prov;
    private String num_Ruc;
    private String rzon_Soc;
    private String direccion;
    private String telf;
    
    @Temporal(TemporalType.DATE)
   @DateTimeFormat(iso=ISO.DATE)
	 private Date fech_Registro_Prove; 
	
}
