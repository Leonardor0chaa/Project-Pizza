package br.com.projeto.pizzaria3d.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.pizzaria3d.model.entity.Aluno;
import br.com.projeto.pizzaria3d.model.repository.AlunoRepository;

public class AlunoService implements AlunoRepository{
	
	@Override
	public Aluno find() {
		Aluno aluno = new Aluno(96299, "Xablauzin", 30);
		return aluno;
	}
	
	@Override
	public List<Aluno> findAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(86314, "Leonardo", 24));
		alunos.add(new Aluno(86134, "Gustavo", 14));
		alunos.add(new Aluno(86299, "Luiz Gaylherme", 25));
		return alunos;
	}

	@Override
	public Aluno findByRm(long rm) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(86314, "Leonardo", 24));
		alunos.add(new Aluno(86134, "Gustavo", 14));
		alunos.add(new Aluno(86299, "Luiz Gaylherme", 25));
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getRm() == rm) {
				return alunos.get(i);
			}
		}
		return null;
	}
	
	
}
