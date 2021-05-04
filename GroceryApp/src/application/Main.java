package application;
	
import Controller.*;
import Model.Customer;
import Model.Inventory;
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
