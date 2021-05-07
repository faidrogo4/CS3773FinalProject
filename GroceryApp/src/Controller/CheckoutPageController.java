package Controller;

import Model.Product;
import application.Main;
import com.jfoenix.controls.JFXButton;
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
		Main.current.checkout();
		orderPress(actionEvent);
	}

	public void clearPress(final ActionEvent actionEvent) {
		Main.current.clearOrder();
		tableview.setItems(null);
	}
}
