package com.tw.shopping.item;

import java.util.ResourceBundle;
 
public enum ItemType {
	/*
	 * This is a Enum type for Items 
	 * 
	 */
	BOOK("BOOK",true),FOOD("FOOD",true),MEDICINE("MEDICINE",true),OTHERS("OTHERS",false);
	private String itemTypeName;
	private boolean isNecessaryItem ;
	private static final ResourceBundle bundle =ResourceBundle.getBundle("com.tw.shopping.item.ItemTypeName");
	
	ItemType(String itemTypeName,boolean isNecessaryItem){
		this.itemTypeName =itemTypeName;
		this.isNecessaryItem = isNecessaryItem;
	}
	public  String getTypeName(){
		return this.itemTypeName;
	}
	public static ItemType getType(String typeName){
		String typeValue = bundle.getString(typeName);
		if (typeName==null){
			return null;
		}else if ("BOOK".equals(typeValue)){
			return BOOK;
		}else if("FOOD".equals(typeValue)){
			return FOOD;
		}else if ("MEDICINE".equals(typeValue)){
			return MEDICINE;
		}else if("OTHERS".equals(typeValue)){
			return OTHERS;
		}else {
			return null;
		}
		
	}
	public boolean isNecessaryItem(){
		return this.isNecessaryItem;
	}
}
