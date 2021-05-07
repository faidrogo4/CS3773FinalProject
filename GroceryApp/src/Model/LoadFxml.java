package Model;

import java.net.URL;

import application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class LoadFxml {
	private Pane view;
	
	public Pane getPage(String fileName){	
		try{
			
			URL fileUrl = Main.class.getResource("/controller/" + fileName + ".fxml");
			//System.out.println(fileUrl);
			if(fileUrl==null){
				throw new java.io.FileNotFoundException("FXML file can't be found");
			}
			//new FXMLLoader();
			view = FXMLLoader.load(fileUrl);
		}
		catch(Exception e){
			System.out.println("No page "+fileName+" please check FXMLLoader.");
		}
		
		return view;			
		
	}
}
