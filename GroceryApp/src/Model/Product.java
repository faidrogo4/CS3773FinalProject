package Model;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.util.Comparator;

public class Product {

		private String name;  
		private int id;			// id will also serve as index placement in Product ArrayList of Inventory
		private double price;
		private int quantity;
		private double discount;
		public static Comparator<Product> ComparePrice = new Comparator<Product>() {
			public int compare(final Product o1, final Product o2) {
				double price1 = o1.getPrice();
				double price2 = o2.getPrice();
				int ret = (int) (price1-price2);
				return ret;
			}
		};
		public static Comparator<Product> CompareName = new Comparator<Product>() {
			public int compare(final Product o1, final Product o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				int ret = name1.compareTo (name2);
				return ret;
			}
		};
		public Product(Product p){
			this.name = p.getName();
			this.id=p.getId();
			this.price = p.getPrice();
			this.quantity=p.getQuantity();
			this.discount=p.getDiscount();
		}
		public Product(String pName, int pId, double pPrice, int pQuant, double pDiscount) {
			name = pName;
			id = pId;
			price = pPrice;
			quantity = pQuant;
			discount = pDiscount;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public void setDiscount(double discount) {
			this.discount = discount;
		}
		
		public double getDiscount() {
			return this.discount;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getId() {
			return this.id;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public int getQuantity() {
			return this.quantity;
		}

		public int decQuantity(){
			if(this.quantity>1){
				this.quantity--;
			}else {
				this.quantity = 0;
			}
			return this.quantity;
		}

		public int incQuantity(){
			this.quantity++;
			return this.quantity;
		}

		public double getQPrice(){
			return this.price*this.quantity;
		}



}
