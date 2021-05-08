package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;


public class Inventory {
	public ArrayList<Product> p;

	protected int productCount;
	
	public Inventory() {
		p = new ArrayList<>();
		productCount = 0;
	}
	public void unClear(Product product){
		for (Product a:this.p) {
			if(a.getName().equals(product.getName())){
				a.setQuantity(a.getQuantity()+product.getQuantity());
			}
		}
	}

	public void addProduct(Product prod) {
		if(p.contains(prod)){
			p.get(p.indexOf(prod)).incQuantity();
		}else {

		p.add(new Product(prod.getName(),prod.getId(),prod.getPrice(),prod.getQuantity(),prod.getDiscount()));
			productCount++;
		}
	}

	public int getProductCount(){
		return productCount;
	}

	public void deleteProduct(Product prod) {
		p.remove(prod.getId());
		productCount--;
	}

	/**
	 * getListByPrice(boolean)
	 *
	 * @param fromLow
	 * If true, then sorts from lowest price to highest price product.
	 * @return
	 *  An array list of products with either the highest price first or the lowest price first depending on the
	 *  bool passed
	 */
	public ArrayList<Product> getListByPrice(boolean fromLow){
		p.sort(Product.ComparePrice);
		if(fromLow){
			return p;
		}
		Collections.reverse(p);
		return p;
	}
	/**
	 * getListByName(boolean)
	 *
	 * @param fromLow
	 * If true, then sorts names alphabetically, otherwise it will return reverse
	 * @return
	 *  An array list of products sorted either alphabetically or reverse alphabetically depending on
	 *  bool passed
	 */
	public ArrayList<Product> getListByName(boolean fromLow){
		p.sort(Product.CompareName);
		if(fromLow){
			return p;
		}
		Collections.reverse(p);
		return p;
	}


	public ObservableList<Product> getObservable(){
		return FXCollections.observableList(getListByName(true));
	}
	
	
}
