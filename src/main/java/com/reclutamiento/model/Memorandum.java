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
@Table(name = "tb_memorandum")
@Data
public class Memorandum {
	@Id
	private int id_memo;
	private String destinatario;
	private String Asunto;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;
	private int id_User;
	private int id_req_cas;
	
	@ManyToOne
	@JoinColumn(name = "id_User", insertable = false, updatable = false)
	private Usuario objUsu;
	
	@ManyToOne
	@JoinColumn(name = "id_req_cas", insertable = false, updatable = false)
	private ReqCas objReqCas;
}
