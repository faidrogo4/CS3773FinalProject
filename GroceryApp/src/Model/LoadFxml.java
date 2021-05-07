package Model;

import java.net.URL;

import application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class LoadFxml {
	private Pane view;
	
	public Pane getPage(String fileName){	
		try{
			
			URL fileURL = Main.class.getResource("/controller/" + fileName + ".fxml");
			//System.out.println(fileUrl);
			if(fileURL ==null){
				throw new java.io.FileNotFoundException("FXML file cannot be found.");
			}
			//new FXMLLoader();
			view = FXMLLoader.load(fileURL);
		}
		catch(Exception e){
			System.out.println("No page "+fileName+" please check LoadFxml.");
		}
		
		return view;			
		
	}
}
