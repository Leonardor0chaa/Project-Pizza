package br.com.projeto.pizzaria3d.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.pizzaria3d.model.entity.Produto;
import br.com.projeto.pizzaria3d.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}

	// jakarta.transaction.Transactional
	@Transactional
	public Produto create(Produto produto) {

		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");

		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto inativar(long id) {
		Optional<Produto> _produto = 
				produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			produtoAtualizado.setStatusProd("INATIVO");
			
			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}
	
	
	@Transactional
	public Produto alterar(long id, Produto produto) {
		Optional<Produto> _produto = 
				produtoRepository.findById(id);
		
		if (_produto.isPresent()) {
			Produto produtoAtualizado = _produto.get();
			
			produtoAtualizado.setPreco(produto.getPreco());
			produtoAtualizado.setDescricao(produto.getDescricao());
			
			return produtoRepository.save(produtoAtualizado);
		}
		return null;
	}

}




