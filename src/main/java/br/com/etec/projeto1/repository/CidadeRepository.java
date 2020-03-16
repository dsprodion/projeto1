package br.com.etec.projeto1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.etec.projeto1.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
	public Page<Cidade> findByNomeContaining(String nome, Pageable pageable);
}
