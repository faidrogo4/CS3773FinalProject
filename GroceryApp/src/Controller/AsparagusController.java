package Controller;

import Model.Order;
import Model.Product;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

public class AsparagusController {

	@FXML
	private Label nameLabel;
	
	@FXML 
	private Label priceLabel;
	
	@FXML
	private ImageView itemImage;
	
	@FXML
	public JFXButton addToCartButton;
	
	private Product item;

	private Order currOrder;

	public void initialize(){

		currOrder = Main.current.getOrder();
		item = Main.inventory.getListByName(true).get(1);
		if(item.getQuantity()<=0){
			addToCartButton.setVisible(false);
		}

	}

	
	@FXML
	void handleAddToCartButton(ActionEvent event) throws IOException {
		if(this.item.getQuantity()>0){
			this.currOrder.addProduct(new Product(this.item));
			this.item.decQuantity();
		}
		if(this.item.getQuantity()<=0){
			addToCartButton.setVisible(false);
		}
	}
	
}
