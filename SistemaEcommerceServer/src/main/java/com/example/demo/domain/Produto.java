package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private Double preco;
	
	public Produto() {
	}

	public Produto(Integer codigo, String nome, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
