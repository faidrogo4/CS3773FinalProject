package Controller;
import Model.IncorrectPasswordException;
import application.Main;
import Model.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

	@FXML
	public JFXButton BackButton;
	
	@FXML
	public JFXButton RegisterButton;
	
	@FXML
	public JFXTextField FirstName;
	
	@FXML
	public JFXTextField LastName;
	
	@FXML
	public JFXTextField EmailField;
	
	@FXML
	public JFXPasswordField PasswordField;

	public Text InstructionLabel;


	public void buttonPress(final ActionEvent actionEvent) throws IOException {
		Customer newCust = null;
		try{

			String pass= PasswordField.getText();
			newCust = new Customer(EmailField.getText(),pass);
			newCust.setName(FirstName.getText(),LastName.getText());
		}catch(IncorrectPasswordException e){
			InstructionLabel.setText(e.getMessage());
			InstructionLabel.setFill(Color.RED);
			PasswordField.setText("");
			return;
		}

		Main.customers.add(newCust);
		Main.current = newCust;
		Parent homeParent = FXMLLoader.load(getClass().getResource("HomePageView.fxml"));
		Scene homeScene = new Scene(homeParent);
		Stage nextStage=(Stage) RegisterButton.getScene().getWindow();
		nextStage.setScene(homeScene);


	}
	public void backPress(ActionEvent actionEvent) throws IOException{
		Parent initialParent = FXMLLoader.load(getClass().getResource("InitialView.fxml"));
		Scene initalScene = new Scene(initialParent);
		Stage nextStage= (Stage) BackButton.getScene().getWindow();
		nextStage.setScene(initalScene);
	}
}
