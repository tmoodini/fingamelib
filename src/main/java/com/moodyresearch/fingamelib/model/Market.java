package com.moodyresearch.fingamelib.model;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Market {
	
	private ArrayList<SalesOrder> market;
	
	public Market() {
		this.market = new ArrayList<SalesOrder>();
	}
	
	public void addSalesOrder(SalesOrder order) {
		
		
		if(order.getOrderType() == "buy") {
			if(this.processBuyOrder(order)) {
				order.setStatus("complete");
				
			}
			
		}
		
		if(order.getOrderType() == "sell") {
			if(this.processSellOrder(order)) {
				order.setStatus("complete");
			}
			
		}
		
		if(order.getQuantity() > 0) {
		this.market.add(order);
		}
		
	}
	
	public SalesOrder getOrderbyIndex(int i) {
		return market.get(i);
	}
	
	public SalesOrder findMatch(SalesOrder s) {
		
		
		
		if(s.getOrderType().equals("buy")){	
		for(int i = 0; i < market.size();i++) {
			if(market.get(i).getStock().getSymbol().equals( s.getStock().getSymbol())
					&& market.get(i).getOrderType().equals("sell"))
			{
				
				return market.get(i);
			}//end if
		}//end for
		}//end if	
		
		return new SalesOrder();
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
					+ " " + currency.format(market.get(i).getPricePerShare()) + " " +
							market.get(i).getOrderType() + " " +
					 		market.get(i).getQuantity() + " " +
							market.get(i).getPlayer().getName());
		}
	}
	
	private boolean processBuyOrder(SalesOrder so) {
		for(int i = 0; i < market.size();i++) {
			if(market.get(i).getStock().getSymbol().equals( so.getStock().getSymbol())
					&& market.get(i).getOrderType().equals("sell"))
			{
				Player seller = market.get(i).getPlayer();
				BigDecimal sellerGain = so.getPricePerShare().multiply(BigDecimal.valueOf(so.getQuantity()));
				seller.setCash(seller.getCash().add(sellerGain));
				
				
				StockHolding sh = new StockHolding(so.getStock(),so.getPricePerShare(),so.getQuantity());
				so.getPlayer().getHoldings().add(sh);
				market.get(i).setQuantity(market.get(i).getQuantity() - so.getQuantity());
				so.setQuantity(0);
				if(market.get(i).getQuantity() == 0) {
					market.remove(i);
				}
				
				return true;
			}//end if
	}
		return false;
	}
	
	private boolean processSellOrder(SalesOrder so) {
		for(int i = 0; i < market.size();i++) {
			if(market.get(i).getStock().getSymbol().equals( so.getStock().getSymbol())
					&& market.get(i).getOrderType().equals("buy"))
			{
				Player seller = so.getPlayer();
				BigDecimal sellerGain = so.getPricePerShare().multiply(BigDecimal.valueOf(so.getQuantity()));
				seller.setCash(seller.getCash().add(sellerGain));
				
				
				StockHolding sh = new StockHolding(so.getStock(),so.getPricePerShare(),so.getQuantity());
				market.get(i).getPlayer().getHoldings().add(sh);
				market.get(i).setQuantity(market.get(i).getQuantity() - so.getQuantity());
				
				return true;
			}//end if
	}
		return false;
	}

}
