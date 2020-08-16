package com.u2d.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.u2d.projeto.dto.TransactionDTO;
import com.u2d.projeto.service.TransactionService;

@RestController
@RequestMapping("transacao")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	@PostMapping
	public ResponseEntity<TransactionDTO> efetuarPagamento(@Valid @RequestBody TransactionDTO transactionDTO){
		TransactionDTO retorno = service.payment(transactionDTO);
		return new ResponseEntity<TransactionDTO>(retorno, HttpStatus.OK);
	}

}
