package Controller;

import Model.Order;
import Model.Product;
import application.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CheckoutPageController {
	
	@FXML
	public JFXButton HomeButton;
	
	@FXML
	public JFXButton BrowseButton;
	
	@FXML
	public JFXButton OrdersButton;
	
	@FXML
	public JFXButton CartButton;
	
	@FXML
	public JFXButton CheckoutButton;
	
	@FXML
	public JFXButton clearCartButton;
	
	@FXML
	public TableView<Product> tableview;

	@FXML
	public Label orderTotal;

	@FXML
	public JFXTextField cardField;

	@FXML
	public JFXTextField addressField;


	public void initialize(){
		tableview.setItems(Main.current.getOrder().getObservable());
		orderTotal.setText("$"+Main.current.getOrder().getTotal());
	}

    public void homePress(final ActionEvent actionEvent) throws IOException {
		Parent homeParent = FXMLLoader.load(getClass().getResource("HomePageView.fxml"));
		Scene homeScene = new Scene(homeParent);
		Stage nextStage=(Stage) HomeButton.getScene().getWindow();
		nextStage.setScene(homeScene);
    }

	public void orderPress(final ActionEvent actionEvent) throws IOException {
		Parent orderParent = FXMLLoader.load(getClass().getResource("OrdersPageView.fxml"));
		Scene orderScene = new Scene(orderParent);
		Stage nextStage=(Stage) OrdersButton.getScene().getWindow();
		nextStage.setScene(orderScene);
	}

	public void browsePress(final ActionEvent actionEvent) throws IOException {
		Parent productParent = FXMLLoader.load(getClass().getResource("ProductPageView.fxml"));
		Scene productScene = new Scene(productParent);
		Stage nextStage=(Stage) BrowseButton.getScene().getWindow();
		nextStage.setScene(productScene);
	}

	public void cartPress(final ActionEvent actionEvent) throws IOException {

	}

	public void checkoutPress(final ActionEvent actionEvent) throws IOException {
		if(cardField.getText().length()<16){
			cardField.clear();
			cardField.setPromptText("Please enter valid Card");
			return;
		}
		if(addressField.getText().isEmpty()){
			addressField.setPromptText("Please enter address");
			return;
		}
		Main.current.checkout();
		orderPress(actionEvent);
	}

	public void clearPress(final ActionEvent actionEvent) {
		ArrayList<Product> cleared = Main.current.clearOrder();
		tableview.setItems(null);
		cleared.forEach((a)->{
			Main.inventory.unClear(a);
			System.out.println(a.getName());
		});
		orderTotal.setText("$0.0");

	}
}
