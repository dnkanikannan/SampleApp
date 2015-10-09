package com.tw.shopping.item;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
 
/*
 * author Kanikannan
 * This class represents a product that a customer can buy
 */
public class Item {
	private String itemName;
	private ItemType itemType;
	private BigDecimal basePrice;
	private boolean isImported;
	
	public Item(String itemName,ItemType itemType,BigDecimal basePrice,boolean isImporterd){
		this.itemName = itemName;
		this.basePrice =basePrice;
		this.itemType = itemType;
		this.isImported = isImporterd;
	}
	public boolean isImported() {
		return isImported;
	}
	public String getItemName() {
		return itemName;
	}	
	public ItemType getItemType() {
		return itemType;
	}
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public Map<TaxType,Tax> getApplicableTaxes() {
		//return applicableTaxes;
		Map<TaxType,Tax> applicableTaxes = new HashMap<TaxType, Tax>();
		TaxType [] taxType = TaxType.getApplicableBasicTax(itemType, isImported);
		for (int i = 0; i < taxType.length; i++) {
			applicableTaxes.put(taxType[i], TaxFactory.getInstance().getTax(taxType[i]));
		}
		return applicableTaxes;
	}
}
