package com.produtos.estoque.resource;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.estoque.dominio.EntradaProduto;
import com.produtos.estoque.dominio.Produto;
import com.produtos.estoque.dominio.Error.ResourceNotFoundException;
import com.produtos.estoque.service.ProdutoService;



@RestController
@RequestMapping(value="/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	 
	@GetMapping
	public List<Produto>obterTodos(){
		 
		return produtoService.obterTodos();
	}
	
	

	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> obterporId(@PathVariable Integer id) throws ResourceNotFoundException {
		return ResponseEntity.ok(produtoService.obterPorId(id));
        
     
	}
	
	@GetMapping(value="/nome/{descricao}")
    public ResponseEntity<List<Produto>> find(@PathVariable String descricao) {
		return ResponseEntity.ok(produtoService.buscarNome(descricao));
		    	
    }
	
	       
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	

	@DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id)throws ResourceNotFoundException {
        produtoService.deletar(id);
		return "Produto com id:" + id + " foi deletado com sucesso!";

	}

	@PutMapping(value="/{id}")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        produto.setId(id);
        return produtoService.atualizar(produto);

	}
	
	@PostMapping("/{id}/entradas")
	@Transactional
	public ResponseEntity<?> realizarEntrada(@PathVariable  Integer id){
	    EntradaProduto entradaProduto = produtoService.realizarEntrada(id);
	    return ResponseEntity.ok(entradaProduto);
	
	}
	

}