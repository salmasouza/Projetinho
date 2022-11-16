package com.produtos.estoque.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;
	private String descricao;
	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@OneToMany(
		mappedBy="produto"	,
		fetch=FetchType.LAZY
			)
	List<EntradaProduto> entradas = new ArrayList<>();
	
	
	@OneToMany(
			mappedBy="produto"	,
			fetch=FetchType.LAZY
			)
	List<SaidaProduto> saidas = new ArrayList<>();
	
	
	public Produto(){}
	
	public Produto(Integer id, Double valor, String descricao, LocalDate data) {
		super();
		this.id = id;
		this.valor = valor;
		
		this.descricao = descricao;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setDate(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	public void add(Produto produto) {
	}

	public List<EntradaProduto> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<EntradaProduto> entradas) {
		this.entradas = entradas;
	}

	public List<SaidaProduto> getSaidas() {
		return saidas;
	}

	public void setSaidas(List<SaidaProduto> saidas) {
		this.saidas = saidas;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
}
	
    

