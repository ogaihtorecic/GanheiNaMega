package io.apiary.megasena.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Aposta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer concurso;
	private Set<Integer> dezenas = new TreeSet<Integer>();
	private Integer acertos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getConcurso() {
		return concurso;
	}
	
	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}
	
	public Set<Integer> getDezenas() {
		return dezenas;
	}
	
	public void setDezenas(Set<Integer> dezenas) {
		this.dezenas = dezenas;
	}
	
	public Integer getAcertos() {
		return acertos;
	}
	
	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}
	
}
