package br.com.projeto.pizzaria3d.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.pizzaria3d.model.entity.Categoria;
import br.com.projeto.pizzaria3d.service.CategoriaService;

@RestController
@RequestMapping("/categoria/")
public class CategoriaController {

	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categorias = categoriaService.findAll();

		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable long id) {
		Categoria categoria = categoriaService.findById(id);

		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {

		Categoria _categoria = categoriaService.create(categoria);

		return new ResponseEntity<Categoria>(_categoria, HttpStatus.OK);
	}
}
