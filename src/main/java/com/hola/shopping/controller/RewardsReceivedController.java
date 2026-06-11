package com.hola.shopping.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hola.shopping.dto.RewardResponse;
import com.hola.shopping.entity.Transaction;
import com.hola.shopping.service.RewardsReceivedService;

@RestController
@RequestMapping("/holaRewards")
public class RewardsReceivedController {

	@Autowired
	private RewardsReceivedService rewardsReceivedservice;

	@GetMapping("/{customerId}")
	public ResponseEntity<RewardResponse> getRewards(@PathVariable int customerId) {

	    List<Transaction> transactions = getMockTransactions(customerId);
	    Map<String, Integer> monthly = rewardsReceivedservice.getMonthlyRewards(transactions);
	    int total = rewardsReceivedservice.getTotalRewards(monthly);

	    RewardResponse response = new RewardResponse(customerId, monthly, total);

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	private List<Transaction> getMockTransactions(int customerId) {

	    return List.of(
	        new Transaction(525001, 120, LocalDate.of(2024, 1, 10)),
	        new Transaction(525002, 75, LocalDate.of(2024, 1, 15)),
	        new Transaction(525003, 200, LocalDate.of(2024, 1, 10)),
	        new Transaction(525004, 50, LocalDate.of(2024, 1, 05)),
	        new Transaction(525001, 520, LocalDate.of(2024, 2, 04)),
	        new Transaction(525002, 55, LocalDate.of(2024, 2, 05)),
	        new Transaction(525003, 500, LocalDate.of(2024, 2, 18)),
	        new Transaction(525004, 80, LocalDate.of(2024, 2, 25)),
	        new Transaction(525001, 90, LocalDate.of(2024, 3, 01)),
	        new Transaction(525002, 180, LocalDate.of(2024, 3, 25)),
	        new Transaction(525003, 700, LocalDate.of(2024, 3, 10)),
	        new Transaction(525004, 250, LocalDate.of(2024, 3, 05))
	    ).stream()
	    	    .filter(t -> t.getCustomerId() == customerId) // ✅ IMPORTANT FIX
	    	    .toList();
	}
}