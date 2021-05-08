package Controller;

import application.Main;
import com.jfoenix.controls.JFXButton;

import Model.LoadFxml;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ProductPageController implements Initializable{

	@FXML
	public JFXButton HomeButton;
	
	@FXML
	public JFXButton BrowseButton;
	
	@FXML
	public JFXButton OrdersButton;
	
	@FXML
	public JFXButton CartButton;

	public ScrollPane productViewer;
	
	@FXML
	public GridPane grid;

	
	/*
	 * initialize() will load products into grid on ProductPageView load.
	 * */
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		//grid.getRowConstraints().add(new RowConstraints(0));
		//grid.getColumnConstraints().add(new ColumnConstraints(0));
		grid.setGridLinesVisible(true);
		LoadFxml object = new LoadFxml();
		try {
			Pane view = object.getPage("Asparagus");
			grid.add(view, 0, 0, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view1 = object.getPage("Banana");
			grid.add(view1, 1, 0, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view2 = object.getPage("Carrot");
			grid.add(view2, 0, 1, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view3 = object.getPage("Broccoli");
			grid.add(view3, 1, 1, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view4 = object.getPage("Kiwi");
			grid.add(view4, 0, 2, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view5 = object.getPage("Mango");
			grid.add(view5, 1, 2, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view6 = object.getPage("Apple");
			grid.add(view6, 0, 3, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}try {
			Pane view7 = object.getPage("Orange");
			grid.add(view7, 1, 3, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		
    }


	public void homePress(final ActionEvent actionEvent) throws IOException{
		Parent homeParent = FXMLLoader.load(getClass().getResource("HomePageView.fxml"));
		Scene homeScene = new Scene(homeParent);
		Stage nextStage=(Stage) HomeButton.getScene().getWindow();
		nextStage.setScene(homeScene);
	}

	public void browsePress(final ActionEvent actionEvent) {

	}

	public void ordersPress(final ActionEvent actionEvent) throws IOException{
		Parent orderParent = FXMLLoader.load(getClass().getResource("OrdersPageView.fxml"));
		Scene orderScene = new Scene(orderParent);
		Stage nextStage=(Stage) OrdersButton.getScene().getWindow();
		nextStage.setScene(orderScene);
	}

	public void cartPress(final ActionEvent actionEvent) throws IOException {
		Parent checkoutParent = FXMLLoader.load(getClass().getResource("CheckoutPageView.fxml"));
		Scene checkoutScene = new Scene(checkoutParent);
		Stage nextStage=(Stage) CartButton.getScene().getWindow();
		nextStage.setScene(checkoutScene);
	}


	/*
	@FXML
	private Button viewProduct;
	
	@FXML
	private Button addProduct;
	
	@FXML
	private Button viewOrder;
	
	@FXML 
	private TextField text;
	
	*/
	
	
}
