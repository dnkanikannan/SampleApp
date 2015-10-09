package com.tw.shopping.item;

import java.math.BigDecimal;
 
public class Tax {
	private TaxType taxType;
	private BigDecimal taxRate;
	
	Tax(TaxType taxType,BigDecimal taxRate){
		this.taxType = taxType;
		this.taxRate = taxRate;
	}

	public TaxType getTaxType() {
		return taxType;
	}
	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	
}
