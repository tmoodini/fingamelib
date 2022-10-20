package com.moodyresearch.fingamelib.model;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Market {
	
	private ArrayList<SalesOrder> market;
	
	public Market() {
		this.market = new ArrayList<SalesOrder>();
	}
	
	public void addSalesOrder(SalesOrder order) {
		
		this.market.add(order);
		
	}
	
	public SalesOrder getOrderbyIndex(int i) {
		return market.get(i);
	}
	
//	public SalesOrder processOrder(SalesOrder order) {
//		
//		if(order.getOrderType() == "sell") {
//			order.getPlayer().
//		}
//		
//	}
	
	public void printMarket() {
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		for(int i = 0; i < market.size(); i++) {
			System.out.println(market.get(i).getStock().getSymbol() 
					+ " " + currency.format(market.get(i).getPricePerShare()));
		}
	}

}
