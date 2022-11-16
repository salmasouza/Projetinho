package com.produtos.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.estoque.dominio.EntradaProduto;

@Repository
public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, Integer> {
	
	

}
