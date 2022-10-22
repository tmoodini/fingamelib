package com.moodyresearch.fingamelib.model;

import java.math.BigDecimal;

public class SalesOrder {
	
	private long orderID;
	private Player player;
	private Stock stock;
	private int quantity;
	private String orderType;
	private BigDecimal pricePerShare;
	private String status;
	
	public SalesOrder() {
		
	}
	
	public SalesOrder (Player p, Stock s, int qty, String orderType, BigDecimal pricePerShare)
	{
		this.player = p;
		this.stock = s;
		this.quantity = qty;
		this.orderType = orderType;
		this.pricePerShare = pricePerShare;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
