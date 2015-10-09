package com.tw.shopping.item;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ResourceBundle;

public final class TaxFactory {
	/*
	 * This is a singleton class which will cache all the tax objects in a HashMap 
	 */
	private static final HashMap<TaxType,Tax> taxMap = new HashMap<TaxType,Tax>();
	private static final TaxFactory taxFactory = new TaxFactory();
	private static final ResourceBundle taxRateBundle =ResourceBundle.getBundle("com.tw.shopping.item.TaxRate");
	static {
		loadAllTax();
	}
	private TaxFactory(){
		
	}
	private  static void loadAllTax(){
		TaxType taxTypes [] = TaxType.values();
		for (TaxType taxType : taxTypes) {
			BigDecimal taxRate = new BigDecimal(taxRateBundle.getString(taxType.name()));
			taxMap.put(taxType, new Tax(taxType,taxRate));
		}
	}
	public static TaxFactory getInstance(){
		return taxFactory;
	}
	public Tax getTax(TaxType taxType){
		return taxMap.get(taxType);
	}
}
