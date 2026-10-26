package br.edu.ifsp.cadastro.reports;

import java.math.BigDecimal;

import javax.persistence.*;

import org.hibernate.annotations.Subselect;

@Entity
@Subselect("select * from estudanterelatorio")
public class EstudanteRelatorio {
	@Id
	private Long id;
	private String nome;
	private Character sexo;
	private Boolean pcd;
	private BigDecimal ira;
	private String curso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public Boolean getPcd() {
		return pcd;
	}
	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}
	public BigDecimal getIra() {
		return ira;
	}
	public void setIra(BigDecimal ira) {
		this.ira = ira;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
