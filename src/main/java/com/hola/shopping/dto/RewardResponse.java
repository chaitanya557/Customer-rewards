package com.hola.shopping.dto;

import java.util.Map;

public class RewardResponse {
    public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Map<String, Integer> getMonthlyRewards() {
		return monthlyRewards;
	}
	public void setMonthlyRewards(Map<String, Integer> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}
	public int getTotalRewards() {
		return totalRewards;
	}
	public RewardResponse(int customerId2, Map<String, Integer> monthlyRewards, int totalRewards) {
		super();
		this.customerId = customerId2;
		this.monthlyRewards = monthlyRewards;
		this.totalRewards = totalRewards;
	}
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}
	private int customerId;
    private Map<String, Integer> monthlyRewards;
    private int totalRewards;
}