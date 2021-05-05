package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersPageController {
	
	@FXML
	public JFXButton HomeButton;
	
	@FXML
	public JFXButton BrowseButton;
	
	@FXML
	public JFXButton OrdersButton;
	
	@FXML
	public JFXButton CartButton;
	
	@FXML
	public JFXButton previousButton;
	
	@FXML
	public JFXButton nextButton;
	
	@FXML
	public Label orderNumber;
	
	@FXML
	private JFXTreeTableView tableview;
	

    public void homePress(final ActionEvent actionEvent) throws IOException{
		Parent homeParent = FXMLLoader.load(getClass().getResource("HomePageView.fxml"));
		Scene homeScene = new Scene(homeParent);
		Stage nextStage=(Stage) HomeButton.getScene().getWindow();
		nextStage.setScene(homeScene);
    }

	public void browsePress(final ActionEvent actionEvent) throws IOException{
		Parent productParent = FXMLLoader.load(getClass().getResource("ProductPageView.fxml"));
		Scene productScene = new Scene(productParent);
		Stage nextStage=(Stage) BrowseButton.getScene().getWindow();
		nextStage.setScene(productScene);
	}

	public void orderPress(final ActionEvent actionEvent) {
	}

	public void checkoutPress(final ActionEvent actionEvent) throws IOException {
		Parent checkoutParent = FXMLLoader.load(getClass().getResource("CheckoutPageView.fxml"));
		Scene checkoutScene = new Scene(checkoutParent);
		Stage nextStage=(Stage) CartButton.getScene().getWindow();
		nextStage.setScene(checkoutScene);
	}
	
}
