package com.processos.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	private String cpf;
	
	//@Column(unique = true)
	private String tipoParte;
	
//	@OneToMany(mappedBy = "parte", cascade = CascadeType.ALL)
//	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "processo")
	private Set<ParteProcesso> parteProcessos = new HashSet<>();
	
	public Parte() {
		
	}

	public Parte(Integer id, String nome, Date dataNascimento, String cpf, String tipoParte) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.tipoParte = tipoParte;
	}
	
	@JsonIgnore
	public Set<ParteProcesso> getParteProcessos() {
		return parteProcessos;
	}

	
	public void setParteProcessos(Set<ParteProcesso> parteProcessos) {
		this.parteProcessos = parteProcessos;
	}

	//Lista de processo baseada na lista na lista de processos com partes
   @JsonIgnore
	public List<Processo> getParteProcesso(){
		List<Processo> lista = new ArrayList<>();
		for(ParteProcesso x : parteProcessos) {
			lista.add(x.getProcesso());
	}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoParte() {
		return tipoParte;
	}

	public void setTipoParte(String tipoParte) {
		this.tipoParte = tipoParte;
	}

//	public List<Endereco> getEnderecos() {
//		return enderecos;
//	}
//
//	public void setEnderecos(List<Endereco> enderecos) {
//		this.enderecos = enderecos;
//	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parte other = (Parte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
