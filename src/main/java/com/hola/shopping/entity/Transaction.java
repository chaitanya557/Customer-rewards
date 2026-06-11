package com.hola.shopping.entity;

import java.time.LocalDate;

public class Transaction {
	public Transaction(int customerId, int amount, LocalDate date) {
		// TODO Auto-generated constructor stub
		this.customerId=customerId;
		this.amount = amount;
		this.date = date;
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private int customerId;
	private double amount;
	private LocalDate date;
	}