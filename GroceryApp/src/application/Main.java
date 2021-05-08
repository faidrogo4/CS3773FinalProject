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
	@Override
	public void start(Stage primaryStage) {
		inventory=new Inventory();
		inventory.addProduct(new Product("Apple",0,0.65,8,0.15));
		inventory.addProduct(new Product("Asparagus",1,2.98,10,0));
		inventory.addProduct(new Product("Banana",2,0.18,18,0));
		inventory.addProduct(new Product("Broccoli",3,1.59,13,0));
		inventory.addProduct(new Product("Carrot",4,0.84,10,1));
		inventory.addProduct(new Product("Kiwi",5,1.98,8,0));
		inventory.addProduct(new Product("Mango",6,0.81,9,0.12));
		inventory.addProduct(new Product("Orange",7,0.68,11,0.18)); 
		try {
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
