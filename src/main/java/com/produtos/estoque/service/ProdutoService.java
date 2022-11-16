package com.produtos.estoque.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.estoque.dominio.EntradaProduto;
import com.produtos.estoque.dominio.Produto;
import com.produtos.estoque.dominio.Error.ResourceNotFoundException;
import com.produtos.estoque.repository.EntradaProdutoRepository;
import com.produtos.estoque.repository.ProdutoRepInter;



@Service
public class ProdutoService  {
    
    @Autowired
    private ProdutoRepInter produtoRepository;
    
    @Autowired
    private EntradaProdutoRepository entradaProdutoRepository;
    
    private Produto buscaProdutoPorId(Integer id) throws ResourceNotFoundException {
    	return produtoRepository.findById(id)
    			.stream().findFirst()
    			.orElseThrow(() -> new ResourceNotFoundException("Produto não é encontrado"));
    }
    
    public Produto obterPorId(Integer id){
        return buscaProdutoPorId(id);   
    }

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }
    
    public List<Produto> buscarNome(String descricao) {
    	return produtoRepository.findByDescricao(descricao);
    }
    
    public Produto adicionar( Produto produto){
       return produtoRepository.save(produto);
    }
    
  
    public void deletar(Integer id) throws ResourceNotFoundException{
        Produto produto = buscaProdutoPorId(id);
        produtoRepository.delete(produto);
    }

    public Produto atualizar(Produto produto){
        return produtoRepository.save(produto);
    }


    public EntradaProduto realizarEntrada(Integer id) {
    	Produto produto = buscaProdutoPorId(id);
    	EntradaProduto entradaProduto = new EntradaProduto();
    	entradaProduto.setPreco(produto.getValor());
    	entradaProduto.setQuantidade(100);
    	entradaProduto.setDataEntrada(LocalDate.now());
    	entradaProduto.setProduto(produto);
    	entradaProdutoRepository.save(entradaProduto);
    	produto.getEntradas().add(entradaProduto);
    	//produtoRepository.save(produto);
    	return entradaProduto;
    	
    }
	
 

}