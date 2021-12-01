package com.easy.bank.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.bank.dao.ContaDAO;
import com.easy.bank.model.Conta;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaDAO contaDAO;

	
	public ArrayList<Conta> listarContas() {
		ArrayList<Conta> lista;
		lista = (ArrayList<Conta>) contaDAO.findAll();

		return lista;
	}

	@GetMapping("/{contaId}")
	public ResponseEntity<Conta> recuperarConta(@PathVariable int contaId) {

		Optional<Conta> conta = contaDAO.findById(contaId);

		if (conta.isPresent()) {
			return ResponseEntity.ok(conta.get());
		}

		return ResponseEntity.notFound().build();
	}

}
