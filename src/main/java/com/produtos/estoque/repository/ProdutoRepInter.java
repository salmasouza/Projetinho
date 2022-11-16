package com.produtos.estoque.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.estoque.dominio.Produto;


@Repository
public interface ProdutoRepInter extends JpaRepository<Produto, Integer> {

	

	List<Produto> findByDescricao(String descricao);


	
	
}

    
