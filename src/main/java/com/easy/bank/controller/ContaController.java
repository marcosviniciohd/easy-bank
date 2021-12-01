package com.easy.bank.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bank.dao.ContaDAO;
import com.easy.bank.model.Conta;

@RestController
public class ContaController {

	@Autowired
	private ContaDAO contaDAO;
	
	
	@GetMapping("/contas")
	public ArrayList<Conta> listarContas(){
		ArrayList<Conta> lista;
		lista = (ArrayList<Conta>) contaDAO.findAll();
		
		return lista;
	}
	
	@GetMapping("/contas/{numero}")
	public Conta recuperarConta(@PathVariable int numero) {
		
		return contaDAO.findById(numero).orElse(null);		
	}

}
