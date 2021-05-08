package Controller;

import Model.Product;
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
		

			Product item =Main.inventory.getListByName(true).get(0);
			Pane view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(1);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(2);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(3);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(4);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(5);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(6);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);

			item =Main.inventory.getListByName(true).get(7);
			view = object.getPage(item.getName());
			view.setVisible((item.getDiscount()>0)?true:false);
			grid.add(view, 0, 0, 1, 1);


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

	public void checkoutPress(ActionEvent actionEvent) throws IOException {
		Main.current.checkout();
		orderButton(actionEvent);
	}

	public void clearPress(ActionEvent actionEvent){
		Main.current.clearOrder();
	}

}
