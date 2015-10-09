package com.tw.shopping.cart;

import java.util.HashSet;
import java.util.Set;

import com.tw.shopping.item.SelectedItem;
 
public class ShopingCart {
	private Set<SelectedItem> selectedItems = new HashSet<SelectedItem>(); 
	public void addOrder(SelectedItem selectedItem){
		selectedItems.add(selectedItem);
	}
	public void removeOrder(SelectedItem selectedItem){
		selectedItems.remove(selectedItem);
	}
	public Set<SelectedItem> getSelectedItems(){
		return selectedItems;
	}
	public void clearCart(){
		selectedItems.clear();
	}

}
