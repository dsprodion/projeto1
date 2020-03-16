package br.com.etec.projeto1.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.etec.projeto1.model.Cliente;
import br.com.etec.projeto1.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/todos")
	public List<Cliente> listarTodosClientes() {
		return clienteService.listarTodosClientes();
	}
	
	@GetMapping()
	public Page<Cliente> pesquisarCliente(@RequestParam(required = false, defaultValue = "") 
	String nome, Pageable pageable){
		return clienteService.pesquisarCliente(nome, pageable);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente cliente = clienteService.findCliente(id);
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Cliente cliente) {
		cliente = clienteService.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("{/id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{/id}")
	public ResponseEntity<Void> update(@PathVariable Integer id,
			@RequestBody Cliente cliente) {
		cliente = clienteService.update(cliente);
		return ResponseEntity.ok().build();
	}
}
