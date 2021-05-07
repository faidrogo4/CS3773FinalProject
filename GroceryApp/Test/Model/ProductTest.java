package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ProductTest")
public class ProductTest {

	Product prodTest;
	String pName;  
	int pId;			
	double pPrice;
	int pQuantity;
	double pDiscount;
	
	@BeforeEach
	void startup() {
		try {
			pName = "testProd";
			pId = 32;
			pPrice = 3.00;
			pQuantity = 2;
			pDiscount = 3;
			Product prodTest = new Product(pName, pId, pPrice, pQuantity, pDiscount);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	@Test
	void nullName() {
		prodTest = null;
		try {
			prodTest = new Product(null, pId, pPrice, pQuantity, pDiscount);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	void emptyName() {
		prodTest = null;
		try {
			prodTest = new Product("", pId, pPrice, pQuantity, pDiscount);
		} catch ()
	}*/
	
	@Test
	void negativeId() {
		prodTest = null;
		try {
			prodTest = new Product(pName, -4, pPrice, pQuantity, pDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void negativePrice() {
		prodTest = null;
		try {
			prodTest = new Product(pName, pId, -10.04, pQuantity, pDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void negativeQuantity() {
		prodTest = null;
		try {
			prodTest = new Product(pName, pId, pPrice,-5, pDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void negativeDiscount() {
		prodTest = null;
		try {
			prodTest = new Product(pName, pId, pPrice, pQuantity, -4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
