package com.shop.listeners;

public class BuyTShirt implements ProcessTShirtListener {

	@Override
	public void processCar(TShirtEvent tShirtEvent) {
		System.out.println("Kopiono koszulkê: " + tShirtEvent.getTShirt());
		
	}

}
