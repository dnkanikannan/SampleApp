package com.tw.shopping.item;
 
public enum TaxType {
	/*
	 * Diffrent kind of tax that can be applicable for a product 
	 */
	SALES_TAX(),IMPORT_DUTY_TAX(),EDUCATION_CESS_TAX(),SERVICE_TAX();
	
	public static TaxType[] getApplicableBasicTax(ItemType itemType,boolean isImportedItem){
		if (!itemType.isNecessaryItem() && isImportedItem){
			return new TaxType[]{SALES_TAX,IMPORT_DUTY_TAX};
		}else if (itemType.isNecessaryItem()&& isImportedItem){
			return new TaxType[]{IMPORT_DUTY_TAX};
		}else if (itemType.isNecessaryItem() && !isImportedItem){
			return new TaxType[0];
		}else if(!itemType.isNecessaryItem() && !isImportedItem){
			return new TaxType[]{SALES_TAX};
		}
		return null;
	}
}
