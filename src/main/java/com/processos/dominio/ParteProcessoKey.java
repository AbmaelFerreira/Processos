package com.processos.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@AllArgsConstructor
//@NoArgsConstructor


@Embeddable
public class ParteProcessoKey implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="processo_id")
	private Processo processo;
	
	@ManyToOne
	@JoinColumn(name="parte_id")
	private Parte parte;
	
	
	@JsonIgnore
	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parte == null) ? 0 : parte.hashCode());
		result = prime * result + ((processo == null) ? 0 : processo.hashCode());
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
		ParteProcessoKey other = (ParteProcessoKey) obj;
		if (parte == null) {
			if (other.parte != null)
				return false;
		} else if (!parte.equals(other.parte))
			return false;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		return true;
	}
	
}
