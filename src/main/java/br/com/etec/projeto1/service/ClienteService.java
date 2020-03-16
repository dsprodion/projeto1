package br.com.etec.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.projeto1.model.Cliente;
import br.com.etec.projeto1.repository.ClienteRepository;
import br.com.etec.projeto1.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente>listarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> pesquisarCliente(String nome, Pageable pageable){
		return clienteRepository.findByNomeContaining(nome, pageable);
	}
	
	public Cliente findCliente(Integer id) {
		Optional<Cliente>cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado!Id= " + id +
				"Tipo" + Cliente.class.getName()));
	}
	
	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Integer id) {
		findCliente(id);
		clienteRepository.deleteById(id);
	}
	
	public Cliente update (Cliente cliente) {
		findCliente(cliente.getId());
		return clienteRepository.save(cliente);
	}
}
