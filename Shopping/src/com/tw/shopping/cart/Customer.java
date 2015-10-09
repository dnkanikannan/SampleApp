package com.tw.shopping.cart;


import com.tw.shopping.item.SelectedItem;
 
public class Customer {
	private String name;
	private ShopingCart myCart;
	private String [] bulkItems;
	private CustomerReceipt receipt; 
	
	public Customer(String name,String [] bulkItems) {
		this.name =name;
		myCart = new ShopingCart();
		this.bulkItems = bulkItems;
	}
	public String getName(){
		return this.name;
	}
	public void doShopping(){
		for (String itemAsString : bulkItems) {
			if ("".equals(itemAsString.trim())){
				continue;
			}
			SelectedItem selectedItem = ShoppingHelper.getSelecedItem(itemAsString);
			if (selectedItem!=null) {
				myCart.addOrder(selectedItem);
			}
		}
		this.receipt = CheckOutCounterImpl.getInstance().checkOutShopping(myCart);
		
	}
	public CustomerReceipt getReceipt(){
		return receipt;
	}
	public void clearCart(){
		myCart.clearCart();
	}
}
