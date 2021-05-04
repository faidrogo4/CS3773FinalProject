package Model;

import java.util.ArrayList;

public class Inventory {
	public ArrayList<Product> p;
	
	public Inventory() {
		p = new ArrayList<Product>();
	}
	
	public void AddProduct(Product prod) {
		p.add(prod);
	}
	
	public void DeleteProduct(Product prod) {
		p.remove(prod.GetId());
	}
	
	//public void 
	
	
}
