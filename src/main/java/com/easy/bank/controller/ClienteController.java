package com.easy.bank.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bank.dao.ClienteDAO;
import com.easy.bank.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;

	@GetMapping
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> listaDeClientes;
		listaDeClientes = (ArrayList<Cliente>) clienteDAO.findAll();

		return listaDeClientes;
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> recuperarConta(@PathVariable int clienteId) {

		Optional<Cliente> cliente = clienteDAO.findById(clienteId);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}

		return ResponseEntity.notFound().build();
	}

}
