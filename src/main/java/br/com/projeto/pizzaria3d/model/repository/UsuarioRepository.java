package br.com.projeto.pizzaria3d.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.pizzaria3d.model.entity.Usuario;


@Repository
public interface UsuarioRepository extends
			JpaRepository<Usuario, Long>{
		
	Usuario findByEmail(String email);	
	
}
