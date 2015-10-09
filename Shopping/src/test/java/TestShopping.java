package test.java;
 
import com.tw.shopping.cart.Customer;
import com.tw.shopping.cart.CustomerReceipt;

import junit.framework.TestCase;

public class TestShopping extends TestCase {

		public void testEnd2EndForShopping() {
			String input[] =new String[]{"1 imported box of chocolates at 10.00","1 imported bottle of perfume at 47.50"};
			Customer customer =new Customer("John",input);
			customer.doShopping(); 
			CustomerReceipt receipt = customer.getReceipt();
			//Check Size of the cart
			assertEquals(2,receipt.getPurchasedItems().size());
			assertEquals("65.15",receipt.getTotalBillValue().toPlainString());
			assertEquals("7.65",receipt.getTotalTax().toPlainString());
			
			input =new String[]{"1 imported bottle of perfume at 27.99","1 bottle of perfume at 18.99","1 packet of headache pills at 9.75","1 imported box of chocolates at 11.25"};
			
			customer =new Customer("John",input);
			customer.doShopping();
			receipt = customer.getReceipt();
			//Check Size of the cart
			assertEquals(4,receipt.getPurchasedItems().size());
			assertEquals("74.68",receipt.getTotalBillValue().toPlainString());
			assertEquals("6.70",receipt.getTotalTax().toPlainString());			
		}
	
		
}
