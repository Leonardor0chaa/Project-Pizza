package br.com.projeto.pizzaria3d.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.pizzaria3d.model.entity.Produto;
import br.com.projeto.pizzaria3d.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	public Produto findById(long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow();
		return produto;
	}
	
	public Produto create(Produto produto) {
		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	
}
