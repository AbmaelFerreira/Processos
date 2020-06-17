package com.processos.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
public class ParteProcesso implements Serializable{

private static final long serialVersionUID = 1L;
	
@JsonIgnore	
@EmbeddedId
private ParteProcessoKey id = new ParteProcessoKey();

@ManyToOne
@JoinColumn(name = "processo_id", insertable = false, updatable = false)
private Processo processo;

@ManyToOne
@JoinColumn(name = "parte_id", insertable = false, updatable = false)
private Parte parte;
	
	public ParteProcesso() {
		
	}

	public ParteProcesso(Processo processo,Parte parte) {
		super();
		id.setProcesso(processo);
		id.setParte(parte);
	}

	public ParteProcessoKey getId() {
		return id;
	}

	public Parte getParte() {
		return id.getParte();
	}
	
	
	public Processo getProcesso() {
		return id.getProcesso();
	}
	
	public void setId(ParteProcessoKey id) {
		this.id = id;
	}

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
		ParteProcesso other = (ParteProcesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
