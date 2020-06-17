package com.processos.dominio;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Processo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nr_processo")	
	private String numeroProcesso;
	
	@JsonFormat(pattern=" dd/MM/yyyy HH:mm")
	@Column(name="data_criacao")
	private Date dataCriacao;
	
	@JsonFormat(pattern=" dd/MM/yyyy HH:mm")
	@Column(name="data_distribuicao")
	private Date dataDistribuicao;
	
	//@JsonIgnore
	@OneToMany(mappedBy ="id.processo")
	private Set<ParteProcesso> parteProcessos = new HashSet<>();
	
//	@ManyToOne
//	@JoinColumn(name = "processo_id")
//	private Classe classe;
	
	public Processo() {
			
	}
	public Processo(Integer id, String numeroProcesso, Date dataCriacao, Date dataDistribuicao) {
		super();
		this.id = id;
		this.numeroProcesso =  numeroProcesso;
		this.dataCriacao = dataCriacao;
		this.dataDistribuicao = dataDistribuicao;
				
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNumeroProcesso() {
		
//		List<Processo> list = processoRepo.findAll();
	
//		 Calendar c = Calendar.getInstance();
//	 
//		 List<Processo> list = processoRepo.findAll();
//		 int p = list.size() -1;
//		 
//		 Processo pro = list.get(p);
//		  
//		 String mes = c.get(Calendar.MONTH)+"";
//		 String ano = c.get(Calendar.YEAR)+".811";
//		 pro.getNumeroProcesso().charAt(pro.getNumeroProcesso() .length()-12);
//		 
//		 return  pro.getNumeroProcesso()+1+"-"+mes+"."+ano;
		 return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		
		this.numeroProcesso = numeroProcesso;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Date dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}
	
//	public Classe getClasse() {
//		return classe;
//	}
//
//	public void setClasse(Classe classe) {
//		this.classe = classe;
//	}
	
	@JsonIgnore
	public Set<ParteProcesso> getParteProcessos() {
		return parteProcessos;
	}

	public void setParteProcessos(Set<ParteProcesso> parteProcessos) {
		this.parteProcessos = parteProcessos;
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
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
