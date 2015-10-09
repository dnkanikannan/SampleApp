package com.tw.shopping.cart;

import java.math.BigDecimal;

import com.tw.shopping.item.Item;
import com.tw.shopping.item.ItemType;
import com.tw.shopping.item.SelectedItem;
 
public final class ShoppingHelper {
	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
	private ShoppingHelper(){
		
	}
	public static SelectedItem getSelecedItem(String line) {
		
		boolean isImported  = line.indexOf("imported")!=-1;
		String pattern = isImported ? "(imported)?((\\s)(at))*" :"((\\s)(at))*" ;
		line = line.replaceAll(pattern, "");
		String inputData [] = line.trim().split("[,\\s]+");
		int  qty = Integer.parseInt(inputData[0]);
		BigDecimal price = new BigDecimal(inputData[inputData.length-1]);
		StringBuilder  itemNameBuilder = new StringBuilder();
		for (int i=1;i<inputData.length -1;i++) {
			itemNameBuilder.append(inputData[i].trim()).append(" ");
			
		}
		itemNameBuilder.delete(itemNameBuilder.length()-1, itemNameBuilder.length());
		
	
		String itemName =itemNameBuilder.toString();
		String itemTypeName =itemName.replaceAll("(\\s)", "_");
		return new SelectedItem(new Item(itemName,ItemType.getType(itemTypeName.trim().toLowerCase()),price,isImported),qty);
	}
	public static void main(String[] args) {
		String line ="1  imported box of chocolates at 10.00";
		getSelecedItem(line);
	}
	public static BigDecimal roundOff(BigDecimal value) {
		value = value.divide(ROUND_FACTOR);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value = value.multiply(ROUND_FACTOR);
		return value.setScale(2);
	}
}
