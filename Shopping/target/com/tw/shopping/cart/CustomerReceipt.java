package com.tw.shopping.cart;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Set;

import com.tw.shopping.item.SelectedItem;
 
public class CustomerReceipt {
	private Set <SelectedItem> purchasedItems ;
	private BigDecimal totalBillValue;
	private BigDecimal totalTax;
	private static final MessageFormat receiptFormatForBillItems = new MessageFormat("{0} {1} {2} : {3} \n");
	private static final MessageFormat receiptFormatForTotals = new MessageFormat("Total Sales Tax :{0} \nTotal Value :{1}");

	
	
	
	public Set<SelectedItem> getPurchasedItems() {
		return purchasedItems;
	}
	public BigDecimal getTotalBillValue() {
		return totalBillValue;
	}
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public CustomerReceipt(BigDecimal totalBillValue,BigDecimal totalTax,Set <SelectedItem> purchasedItems){
		this.totalBillValue = totalBillValue;
		this.totalTax =  totalTax;
		this.purchasedItems = purchasedItems;
	}
	public String toString(){
		StringBuilder receiptBuilder = new StringBuilder ();
		for (SelectedItem selectedItem : purchasedItems) {
			Object itemFormatInput = new Object[]{selectedItem.getRequiredQty(),selectedItem.isImported()?"imported":"", selectedItem.getItemName(),selectedItem.getPriceWithApplicableTax()};
			receiptBuilder.append(receiptFormatForBillItems.format(itemFormatInput));
		}
		Object totalFormatInput = new Object[] {totalTax,totalBillValue};
		receiptBuilder.append(receiptFormatForTotals.format(totalFormatInput));
		return receiptBuilder.toString();
	}

}
