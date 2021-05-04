package Controller;

import application.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
	
	@FXML
	public JFXButton LoginButton;
	
	@FXML
	public JFXButton BackButton;
	
	@FXML
	public JFXTextField EmailField;
	
	@FXML
	public JFXPasswordField PasswordField;

    public void buttonPress(final ActionEvent actionEvent) throws IOException {
		Main.current = null;
    	Main.customers.forEach(( c)->{
    		System.out.println("In list: "+c.getID());
    		System.out.println("Query: "+EmailField.getText());
			if(c.logon(EmailField.getText(),PasswordField.getText())){
				Main.current =c;
			}
		});
    	if(Main.current == null){
    		EmailField.setText("");
    		PasswordField.setText("");
    		EmailField.setPromptText("Logon Failed");
		}else{
			Parent homeParent = FXMLLoader.load(getClass().getResource("HomePageView.fxml"));
			Scene homeScene = new Scene(homeParent);
			Stage nextStage=(Stage) LoginButton.getScene().getWindow();
			nextStage.setScene(homeScene);
		}
    }
}
