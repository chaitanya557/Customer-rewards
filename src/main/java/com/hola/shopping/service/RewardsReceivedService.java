package com.hola.shopping.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hola.shopping.entity.Transaction;

@Service
public class RewardsReceivedService {

	public Map<String, Integer> getMonthlyRewards(List<Transaction> transactions) {

		return transactions.stream().collect(Collectors.groupingBy(t -> t.getDate().getMonth().toString(),
				Collectors.summingInt(t -> calculatePoints(t.getAmount()))));
	}

	public int calculatePoints(double amount) {
	    int points = 0;

	    if (amount > 100) {
	        points += (amount - 100) * 2;
	        amount = 100;
	    }

	    if (amount > 50) {
	        points += (amount - 50);
	    }

	    return points;
	}

	public int getTotalRewards(Map<String, Integer> monthlyRewards) {
		return monthlyRewards.values().stream().mapToInt(Integer::intValue).sum();
	}
}
