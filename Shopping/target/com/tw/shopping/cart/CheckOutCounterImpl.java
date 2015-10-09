package com.tw.shopping.cart;

import java.math.BigDecimal;
import java.util.Set;

import com.tw.shopping.item.SelectedItem;

public final class CheckOutCounterImpl implements CheckOutCounter {

	private static final CheckOutCounterImpl _instance = new CheckOutCounterImpl();
	
	 
	public static final CheckOutCounter getInstance(){
		return _instance;
	}
	private CheckOutCounterImpl(){
		
	}
	
	@Override
	public CustomerReceipt checkOutShopping(ShopingCart cart){
		CustomerReceipt receipt = createCustomerReceipt(cart.getSelectedItems());
		//return the bill
		return receipt;
		
	}
	private CustomerReceipt createCustomerReceipt(Set<SelectedItem> selectedItems){
		BigDecimal totalTax = BigDecimal.ZERO;
		BigDecimal totalBill = BigDecimal.ZERO;
		for (SelectedItem selectedItem : selectedItems) {
			totalTax = totalTax.add(selectedItem.getApplicableTax());
			totalBill = totalBill.add(selectedItem.getPriceWithApplicableTax());
		}
			
		return new CustomerReceipt(totalBill, totalTax, selectedItems);
	}
}
