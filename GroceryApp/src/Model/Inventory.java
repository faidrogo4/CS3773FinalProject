package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;


public class Inventory {
	public ArrayList<Product> p;

	private int productCount;
	
	public Inventory() {
		p = new ArrayList<>();
		productCount = 0;
	}
	
	public void addProduct(Product prod) {
		p.add(prod);
		productCount++;
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
