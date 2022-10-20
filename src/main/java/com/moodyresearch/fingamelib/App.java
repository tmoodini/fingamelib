package com.moodyresearch.fingamelib;

import com.moodyresearch.fingamelib.model.Market;
import com.moodyresearch.fingamelib.model.Player;
import com.moodyresearch.fingamelib.model.SalesOrder;
import com.moodyresearch.fingamelib.model.Stock;
import com.moodyresearch.fingamelib.model.StockHolding;

import java.math.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Market m = new Market();
        System.out.println( "Hello World!" );
        Stock s1 = new Stock(new BigDecimal(1.00),"ABC Inc","abc",100);
        Stock s2 = new Stock(new BigDecimal(1.00),"Bobs PCs","bpc",100);
        Stock s3 = new Stock(new BigDecimal(1.00),"Cathy Clean","cci",100);
        Stock s4 = new Stock(new BigDecimal(1.00),"Mikes Autos","mai",100);
        Stock s5 = new Stock(new BigDecimal(1.00),"Sally Dress Co" ,"sdc",100);
        
        
        Stock[] stocks = {s1, s2, s3, s4, s5};
        
        Player house = new Player();
        house.setName("House");
        
        for(int i =0; i <5; i++) {
        	house.getHoldings().add(new StockHolding(stocks[i], stocks[i].getPrice(), stocks[i].getSharesOutstanding()));
        	m.addSalesOrder(new SalesOrder(house, stocks[i], 
        			stocks[i].getSharesOutstanding(), "sell", stocks[i].getPrice()));
        	
        }
        
        m.printMarket();
        
        
    }
}