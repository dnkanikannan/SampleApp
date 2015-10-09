package com.tw.shopping.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.tw.shopping.cart.Customer;

public class ShoppingMain {
	/*
	 * Main program for Shopping
	 */
	
	public static void main(String[] args) throws IOException{
		final String fileName = "CustomerOrder.txt";
		FileInputStream  fis  = new FileInputStream(new File(fileName));
		ByteBuffer buffer;
	    FileChannel fileChannel = fis.getChannel();
	    long fileSize = fileChannel.size();
	    buffer = ByteBuffer.allocate((int) fileSize);
	    fileChannel.read(buffer);
	    buffer.rewind();
	    String totalFileContent = new String(buffer.array());
	    String orders [] =totalFileContent.split("(\r)?([i|I]nput)*(.)*(:)");
	    int outputCounter = 0;
	    for (String order : orders) {
			if(!("\r".equals(order.trim())||"".equals(order.trim()))){
				String itemLine [] = order.split("([,\r][,\n])");
				Customer customer = new Customer("Hari",itemLine);
				customer.doShopping();
				outputCounter++;
				System.out.println("OUTPUT:"+outputCounter);
				System.out.println(customer.getReceipt());
				customer.clearCart();
				System.out.println("\n");
			
			}
		}
	    
	    		/*Customer customer = new Customer("Hari",inputList);
		customer.doShopping();
		System.out.println(customer.getReceipt());*/
	}
	
/*	public static void main(String[] args) throws IOException{
		final String fileName = "CustomerOrder.txt";
		RandomAccessFile randomeAccessFile  = new RandomAccessFile(new File(fileName),"r");
		String line = null;
		List<String> inputList = new ArrayList<String>();
		while ((line = randomeAccessFile.readLine())!=null){
			inputList.add(line);
		}
		randomeAccessFile.close();
		Customer customer = new Customer("Hari",inputList);
		customer.doShopping();
		System.out.println(customer.getReceipt());
	}
*/

}
