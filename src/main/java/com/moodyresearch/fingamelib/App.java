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
        
        Stock s1 = new Stock(new BigDecimal(1.00),"ABC Inc","abc",100);
        Stock s2 = new Stock(new BigDecimal(1.00),"Bobs PCs","bpc",100);
        Stock s3 = new Stock(new BigDecimal(1.00),"Cathy Clean","cci",100);
        Stock s4 = new Stock(new BigDecimal(1.00),"Mikes Autos","mai",100);
        Stock s5 = new Stock(new BigDecimal(1.00),"Sally Dress Co" ,"sdc",100);
        
        
        Stock[] stocks = {s1, s2, s3, s4, s5};
        
        Player house = new Player();
        house.setName("House");
        house.setCash(new BigDecimal(100));
        
        Player player1 = new Player();
        player1.setName("Bob");
        
        player1.setCash(new BigDecimal(100));
        
        
        
        for(int i =0; i <5; i++) {
        	house.getHoldings().add(new StockHolding(stocks[i], stocks[i].getPrice(), stocks[i].getSharesOutstanding()));
        	m.addSalesOrder(new SalesOrder(house, stocks[i], 
        			stocks[i].getSharesOutstanding(),"sell", stocks[i].getPrice()));
        	
        }
        SalesOrder bo = player1.buyOrder(s1, 50, new BigDecimal(1.00));
        
        
        
        
        
        m.addSalesOrder(bo);
        
        System.out.println("Player 1 cash:" + player1.getCash());
        System.out.println("House cash:" + house.getCash());
        //System.out.print("Player 1 holdings: ");
        player1.printHoldings();
        
        SalesOrder so1 = player1.sellOrder(player1.getHoldingBySymbol(s1), 50, new BigDecimal(1.00));
        m.addSalesOrder(so1);
        
        //System.out.print("Player 1 holdings: ");
        player1.printHoldings();
       // player1.printHoldings();
        System.out.println("Player 1 cash:" + player1.getCash());
        System.out.println("House cash:" + house.getCash());
        m.printMarket();
        
        
    }
}
