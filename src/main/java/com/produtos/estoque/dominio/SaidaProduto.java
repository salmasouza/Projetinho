package com.produtos.estoque.dominio;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class SaidaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private Double preco;
	private Integer quantidade;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="produto_id")
	
	private Produto produto;
	
	
	public SaidaProduto(){}


	public SaidaProduto(Integer id, double preco, Integer quantidade, LocalDate dataSaida, Produto produto) {
		super();
		this.id = id;
		this.preco = preco;
		this.quantidade = quantidade;
		this.dataSaida = dataSaida;
		this.produto = produto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}

