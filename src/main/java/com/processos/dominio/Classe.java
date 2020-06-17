package com.processos.dominio;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	private Integer id;
	private String id_cnj;
	private String ds_classe;
	private String sigla;
	private String tipo;
	
	
	
//	  @JsonIgnore	  
//	  @OneToMany(mappedBy = "classe") 
//	  private List<Processo> processos = new  ArrayList<Processo>();
	 
	
	public Classe() {
		
	}

	public Classe(Integer id, String id_cnj, String ds_classe, String sigla, String tipo) {
		super();
		this.id = id;
		this.id_cnj = id_cnj;
		this.ds_classe = ds_classe;
		this.sigla = sigla;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getId_cnj() {
		return id_cnj;
	}

	public void setId_cnj(String id_cnj) {
		this.id_cnj = id_cnj;
	}

	public String getDs_classe() {
		return ds_classe;
	}

	public void setDs_classe(String ds_classe) {
		this.ds_classe = ds_classe;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
//	public List<Processo> getProcessos()	 {
//		 	return processos;
//	}
//	  
//	public void setProcessos(List<Processo> processos) { 
//		  this.processos = 	  	processos;
//	 }
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	 
	
	
	
	/*
	 * public String toString() { return " Classe{id_cnj='" + id_cnj +
	 * "\', ds_classe=" + ds_classe + ", sigla='" + sigla + "\'}"; }
	 * 
	 * 
	 */
	
	
	
	

}
