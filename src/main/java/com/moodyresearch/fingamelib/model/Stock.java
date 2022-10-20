package com.moodyresearch.fingamelib.model;
import java.math.*;

public class Stock {
	
	private BigDecimal price;
	private String name;
	private String symbol;
	private int sharesOutstanding;
	
	public Stock(BigDecimal price, String name, String symbol, int sharesOutstanding) {
		
		this.price = price;
		this.name = name;
		this.symbol = symbol;
		this.sharesOutstanding = sharesOutstanding;
	}
	
	public Stock() {
		
		this.price = new BigDecimal(0.00);
		this.sharesOutstanding = 100;
		
	}
	
	public BigDecimal getMarketCap() {
		return this.price.multiply(new BigDecimal(this.sharesOutstanding));
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getSharesOutstanding() {
		return sharesOutstanding;
	}

	public void setSharesOutstanding(int sharesOutstanding) {
		this.sharesOutstanding = sharesOutstanding;
	}

	

}
