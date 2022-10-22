package com.moodyresearch.fingamelib.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<StockHolding> holdings;
	private ArrayList<SalesOrder> orders;
	private BigDecimal cash;
	private String name;
	
	public Player() {
		
		this.holdings = new ArrayList<StockHolding>();
		
	}
	
	public Player(ArrayList<StockHolding> holdings,ArrayList<SalesOrder> orders,
			BigDecimal cash,String name) {
		
		this.holdings = holdings;
		this.orders = orders;
		this.cash = cash;
		this.name = name;
		
	}
	
	public SalesOrder buyOrder(Stock s, int qty, BigDecimal offerPrice) {
		
		cash = cash.subtract(offerPrice.multiply(BigDecimal.valueOf(qty)));
		return new SalesOrder(this,s,qty,"buy", offerPrice);
		
	}
	
	public void printHoldings() {
		
		for(int i = 0; i < holdings.size();i++) {
			System.out.println(holdings.get(i).getStock().getSymbol() + " " + holdings.get(i).getQuantity());
		}
	}

	public ArrayList<StockHolding> getHoldings() {
		return holdings;
	}

	public void setHoldings(ArrayList<StockHolding> holdings) {
		this.holdings = holdings;
	}

	public ArrayList<SalesOrder> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<SalesOrder> orders) {
		this.orders = orders;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
