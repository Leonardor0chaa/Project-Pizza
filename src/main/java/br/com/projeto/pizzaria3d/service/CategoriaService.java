package br.com.projeto.pizzaria3d.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto.pizzaria3d.model.entity.Categoria;
import br.com.projeto.pizzaria3d.model.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
	private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}

	public Categoria findById(long id) {
		Categoria categoria = categoriaRepository.findById(id).orElseThrow();
		return categoria;
	}
	
	@Transactional
	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}
