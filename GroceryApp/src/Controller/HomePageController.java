package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
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
	public void initialize(){
		customerFirstNameLabel.setText(Main.current.getFirstName());
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
