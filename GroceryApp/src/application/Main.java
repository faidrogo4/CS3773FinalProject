package application;
	
import Controller.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javax.print.DocFlavor;


public class Main extends Application {
	public static InitialController initialController;
	public static HomePageController homePageController;
	public static LoginController loginController;
	public static OrdersPageController ordersPageController;
	public static ProductPageController productPageController;
	public static SignupController signupController;

	@Override
	public void start(Stage primaryStage) {
		try {
			javafx.scene.Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource("Controller/InitialView.fxml"));
			Scene scene = new Scene(root,350,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
