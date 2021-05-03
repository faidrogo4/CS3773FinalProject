package Controller;

import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class InitialController {
	
	@FXML
	public JFXButton LoginButton;
	
	@FXML
	public JFXButton SignupButton;


	public void buttonPress(final javafx.event.ActionEvent actionEvent)throws IOException {
		JFXButton source = (JFXButton) actionEvent.getSource();
		if(source.getId().equals("LoginButton")){
			System.out.println("LoginClick");
			Parent loginParent =(FXMLLoader.load(getClass().getResource("LoginView.fxml")));
			Scene loginScene = new Scene(loginParent);
			Stage nextStage= (Stage) LoginButton.getScene().getWindow();
			nextStage.setScene(loginScene);

		}else{
			System.out.println("SignupClick");
			Parent signupParent = FXMLLoader.load(getClass().getResource("SignupView.fxml"));
			Scene signupScene = new Scene(signupParent);
			Stage nextStage=(Stage) SignupButton.getScene().getWindow();
			nextStage.setScene(signupScene);
		}

	}
}
