package com.easy.bank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bank.dao.ClienteDAO;
import com.easy.bank.model.Cliente;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	@GetMapping("/clientes")
	public ArrayList<Cliente> listarClientes(){
		ArrayList<Cliente> listaDeClientes;
		listaDeClientes = (ArrayList<Cliente>) clienteDAO.findAll();
		
		return listaDeClientes;
	}
	
	@GetMapping("/clientes/{numero}")
	public Cliente recuperarConta(@PathVariable int numero) {
		return clienteDAO.findById(numero).orElse(null);
	}

}
