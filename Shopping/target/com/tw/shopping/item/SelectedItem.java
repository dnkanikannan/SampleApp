package com.tw.shopping.item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import com.tw.shopping.cart.ShoppingHelper;

 
public class SelectedItem {
	/*
	 * This class contains the Item that is selected by the customer 
	 * Required qty is an attribute which will determain how many quantity of a product that a customer selected.
	 */
	private Item item;
	private int requiredQty;

	public SelectedItem(Item item,int requiredQty) {
		this.item = item;
		this.requiredQty = requiredQty;
	}
	
	public int getRequiredQty() {
		return requiredQty;
	}
	public void setRequiredQty(int requiredQty) {
		this.requiredQty = requiredQty;
	}
	
	public String getItemName() {
		return item.getItemName();
	}
	public ItemType getItemType() {
		return item.getItemType();
	}
	public BigDecimal getBasePrice() {
		return item.getBasePrice();
	}
	public Map<TaxType,Tax> getApplicableTaxes() {
		return item.getApplicableTaxes();
	}
	public boolean isImported(){
		return item.isImported();
	}
	
	public BigDecimal getTaxValue(TaxType taxType){
		Tax tax = item.getApplicableTaxes().get(taxType);
		if (tax==null) {
			throw new IllegalArgumentException(taxType.name()+" does not applicable to "+item.getItemName());
		}
		return ShoppingHelper.roundOff(getPriceWithoutTax().multiply(tax.getTaxRate()));
		
	}
	public BigDecimal getPriceWithoutTax(){
		return item.getBasePrice().multiply(BigDecimal.valueOf(getRequiredQty()));
	}
	public BigDecimal getPriceWithApplicableTax(){
		return getPriceWithoutTax().add(getApplicableTax());
	}
	public BigDecimal getApplicableTax(){
		BigDecimal priceBeforeTax = getPriceWithoutTax();
		Collection<Tax> taxValues = item.getApplicableTaxes().values();
		BigDecimal taxAmount = BigDecimal.ZERO;
		for (Tax tax : taxValues) {
			taxAmount = taxAmount.add(tax.getTaxRate().multiply(priceBeforeTax));
		}
		return ShoppingHelper.roundOff(taxAmount);
	}
}
