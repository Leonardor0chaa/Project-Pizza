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

	public Produto findById(long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow();
		return produto;
	}

	public Produto create(Produto produto) {
		produto.setUrlFoto(null);
		produto.setStatusProd("ATIVO");

		return produtoRepository.save(produto);
	}

	@Transactional
	public Produto inativar(long id) {
		Optional<Produto> _produto = produtoRepository.findById(id);

		if (_produto.isPresent()) {
			Produto produtoAtualizada = _produto.get();
			produtoAtualizada.setStatusProd("inativo");

			return produtoRepository.save(produtoAtualizada);
		}
		return null;
	}

	@Transactional
	public Produto alterar(long id, Produto produto) {
		Optional<Produto> _produto = produtoRepository.findById(id);

		if (_produto.isPresent()) {
			Produto produtoAtualizada = _produto.get();

			produtoAtualizada.setPreco(produto.getPreco());
			produtoAtualizada.setDescricao(produto.getDescricao());

			return produtoRepository.save(produtoAtualizada);
		}
		return null;
	}
}
