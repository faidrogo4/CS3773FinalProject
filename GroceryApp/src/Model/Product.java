package Model;
import java.util.Comparator;

public class Product {

		private String name;  
		private int id;			// id will also serve as index placement in Product ArrayList of Inventory
		private double price;
		private int quantity;
		private double discount;
		public static Comparator<Product> ComparePrice = new Comparator<Product>() {
			public int compare(final Product o1, final Product o2) {
				double price1 = o1.GetPrice();
				double price2 = o2.GetPrice();
				int ret = (int) (price1-price2);
				return ret;
			}
		};
		public static Comparator<Product> CompareName = new Comparator<Product>() {
			public int compare(final Product o1, final Product o2) {
				String name1 = o1.GetPName();
				String name2 = o2.GetPName();
				int ret = name1.compareTo (name2);
				return ret;
			}
		};
		
		public Product(String pName, int pId, double pPrice, int pQuant, double pDiscount) {
			name = pName;
			id = pId;
			price = pPrice;
			quantity = pQuant;
			discount = pDiscount;
		}
		
		public void SetName(String name) {
			this.name = name;
		}

		public void SetId(int id) {
			this.id = id;
		}
		
		public void SetPrice(double price) {
			this.price = price;
		}
		
		public void SetQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public void SetDiscount(double discount) {
			this.discount = discount;
		}
		
		public double GetDiscount() {
			return this.discount;
		}
		
		public String GetPName() {
			return this.name;
		}
		
		public int GetId() {
			return this.id;
		}
		
		public double GetPrice() {
			return this.price;
		}
		
		public int GetQuantity() {
			return this.quantity;
		}



}
