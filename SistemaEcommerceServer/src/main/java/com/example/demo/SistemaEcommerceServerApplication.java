package com.example.demo;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Fornecedor;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.FornecedorRepository;
import com.example.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class SistemaEcommerceServerApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaEcommerceServerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		Cliente cli1 = new Cliente(null, "Mario", "Professor", "Rua da Curva, 12", "Uberlandia", "38400-000", "Brasil",
				"34 998765443", "34 33456787");
		Cliente cli2 = new Cliente(null, "Joao", "Analista", "Rua Onze, 11", "Uberlandia", "38400-000", "Brasil",
				"34 996546787", "34 32324085");
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 500.00);
		Produto p3 = new Produto(null, "Caixa Caneta", 50.00);
		
		Fornecedor f1 = new Fornecedor(null, "Martins Atacadista");
		Fornecedor f2 = new Fornecedor(null, "Peixoto");
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		fornecedorRepository.saveAll(Arrays.asList(f1, f2));
		
	}
}
