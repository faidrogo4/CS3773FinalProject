package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;

import Model.LoadFxml;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import application.Main;

public class HomePageController {

	@FXML
	public JFXButton HomeButton;
	
	@FXML
	public JFXButton BrowseButton;
	
	@FXML
	public JFXButton OrdersButton;
	
	@FXML
	public JFXButton CartButton;
	
	@FXML
	public JFXButton logoutButton;

	@FXML
	private Label customerFirstNameLabel;
	
	@FXML
	private GridPane grid;

	@FXML
	public void initialize(){
		customerFirstNameLabel.setText(Main.current.getFirstName());
		
		grid.setGridLinesVisible(true);
		LoadFxml object = new LoadFxml();
		
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
	}


	
    public void homeButton(final ActionEvent actionEvent) {

    }

	public void productButton(final ActionEvent actionEvent) throws IOException {
		Parent productParent = FXMLLoader.load(getClass().getResource("ProductPageView.fxml"));
		Scene productScene = new Scene(productParent);
		Stage nextStage=(Stage) BrowseButton.getScene().getWindow();
		nextStage.setScene(productScene);
	}

	public void orderButton(final ActionEvent actionEvent) throws IOException {
		Parent orderParent = FXMLLoader.load(getClass().getResource("OrdersPageView.fxml"));
		Scene orderScene = new Scene(orderParent);
		Stage nextStage=(Stage) OrdersButton.getScene().getWindow();
		nextStage.setScene(orderScene);
	}

	public void checkoutButton(final ActionEvent actionEvent) throws IOException{
		Parent checkoutParent = FXMLLoader.load(getClass().getResource("CheckoutPageView.fxml"));
		Scene checkoutScene = new Scene(checkoutParent);
		Stage nextStage=(Stage) CartButton.getScene().getWindow();
		nextStage.setScene(checkoutScene);
	}

	public void logoutPress(final ActionEvent actionEvent) throws IOException{
    	Main.current = null;
		Parent initParent = FXMLLoader.load(getClass().getResource("InitialView.fxml"));
		Scene initScene = new Scene(initParent);
		Stage nextStage=(Stage) CartButton.getScene().getWindow();
		nextStage.setScene(initScene);
	}
}
