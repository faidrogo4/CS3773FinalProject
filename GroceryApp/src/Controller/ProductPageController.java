package Controller;

import application.Main;
import com.jfoenix.controls.JFXButton;

import Model.LoadFxml;
import Model.Product;
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
import java.util.ArrayList;
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

	public ArrayList<Product> p;
	/*
	 * initialize() will load products into grid on ProductPageView load.
	 * */
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		//grid.getRowConstraints().add(new RowConstraints(0));
		//grid.getColumnConstraints().add(new ColumnConstraints(0));
		//grid.setGridLinesVisible(true);
		LoadFxml object = new LoadFxml();
		/*Pane view = object.getPage("asdf");
		Pane view1 = object.getPage("Item");
		Pane view2 = object.getPage("Item");
		Pane view3 = object.getPage("Item");
		Pane view4 = object.getPage("Item");
		Pane view5 = object.getPage("Item");
		Pane view6 = object.getPage("Item");
		Pane view7 = object.getPage("Item");*/

		try {
			Pane view = object.getPage("Item");
			grid.add(view, 0, 0, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view1 = object.getPage("Item");
			grid.add(view1, 1, 0, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view2 = object.getPage("Item");
			grid.add(view2, 0, 1, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view3 = object.getPage("Item");
			grid.add(view3, 1, 1, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view4 = object.getPage("Item");
			grid.add(view4, 0, 2, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view5 = object.getPage("Item");
			grid.add(view5, 1, 2, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Pane view6 = object.getPage("Item");
			grid.add(view6, 0, 3, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}try {
			Pane view7 = object.getPage("Item");
			grid.add(view7, 1, 3, 1, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*if(view == null
		  || view1 == null
		  || view2 == null
		  || view3 == null
		  || view4 == null
		  || view5 == null
		  || view6 == null
		  || view7 == null) { System.out.println("A view is null"); }*/
		
		/*grid.add(view, 0, 0, 1, 1);
		grid.add(view1, 1, 0, 1, 1);
		grid.add(view2, 0, 1, 1, 1);
		grid.add(view3, 1, 1, 1, 1);
		grid.add(view4, 0, 2, 1, 1);
		grid.add(view5, 1, 2, 1, 1);
		grid.add(view6, 0, 3, 1, 1);
		grid.add(view7, 1, 3, 1, 1);*/
		
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

}
