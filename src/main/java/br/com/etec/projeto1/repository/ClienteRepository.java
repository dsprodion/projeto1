package br.com.etec.projeto1.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.etec.projeto1.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
	public Page<Cliente> findByNomeContaining(String nome, Pageable pageable);
}
