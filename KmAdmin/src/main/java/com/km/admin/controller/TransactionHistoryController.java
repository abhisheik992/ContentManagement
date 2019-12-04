package com.km.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.km.admin.model.TransactionHistory;
import com.km.admin.repository.TransactionsRepository;

@RestController
@RequestMapping(path = "/history")
@CrossOrigin
public class TransactionHistoryController {
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	@GetMapping("/all")
	public List<TransactionHistory> getTransactionHistory() {
		
		
		return transactionsRepository.findAll();
	}
	
	@GetMapping("/{content_id}/all")
	public List<TransactionHistory> getTransactionHistoryById(@PathVariable("content_id")Integer id) {
		
		
		
		
		return transactionsRepository.findByContent_id(id);
	}

}
