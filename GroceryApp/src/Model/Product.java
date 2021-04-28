package Model;

public class Product {

		private String name;
		private double price;
		
		
		public Product(String pName, double pPrice) {
			name = pName;
			price = pPrice;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		public String getPName() {
			return this.name;
		}
		
		public double getPPrice() {
			return this.price;
		}
		
		public void Coupon(double discount) {
			price = price - discount;
		}
}
