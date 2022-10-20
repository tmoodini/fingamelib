package com.moodyresearch.fingamelib.model;

import java.math.BigDecimal;

public class StockHolding {
	
	private Stock stock;
	private BigDecimal buyPrice;
	private int quantity;
	
	public StockHolding() {
		
	}
	
	public StockHolding(Stock s, BigDecimal buyPrice, int quantity) {
		this.stock = s;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
		
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
