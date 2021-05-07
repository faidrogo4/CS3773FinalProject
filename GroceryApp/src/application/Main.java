package application;
	
import Controller.*;
import Model.Customer;
import Model.Inventory;
import Model.Product;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
	public static List<Customer> customers;
	public static Customer current;
	public static Inventory inventory;
	public static Product p;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			inventory = new Inventory();
			inventory.AddProduct(new Product("Banana", 0, 0.50, 0, 0.0,"../../Images/banana.png"));
			inventory.AddProduct(new Product("Banana", 0, 0.50, 1, 0.0,"../../Images/kiwi.png"));
			inventory.AddProduct(new Product("Broccoli", 1, 0.60, 2, 0.0,"../../Images/broccoli.png"));
			inventory.AddProduct(new Product("Mango", 2, 0.70, 3, 0.0,"../../Images/mango.png"));
			inventory.AddProduct(new Product("Orange", 3, 0.80, 4, 0.0,"../../Images/orange.png"));
			inventory.AddProduct(new Product("Apple", 4, 0.90, 5, 0.0,"../../Images/apple.png"));
			current=null;
			customers = new ArrayList<Customer>();
			javafx.scene.Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource("Controller/InitialView.fxml"));
			Scene scene = new Scene(root,350,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		

		
	}
	
}
