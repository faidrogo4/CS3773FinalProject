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

public class MangoController {

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
	}
	public void setData(Product item) {
		this.item = item;
		nameLabel.setText(item.getName());
		priceLabel.setText("$" + item.getPrice());
		//Image image = new Image(getClass().getResourceAsStream(item.GetPImgSrc()));
		//itemImage.setImage(image);
	}
	
	public void addToOrder(Order currOrder, Product item) {
		this.currOrder = currOrder;		
		currOrder.addProduct(item);
	}
	
	@FXML
	void handleAddToCartButton(ActionEvent event) throws IOException {
		addToOrder(currOrder, item);
		System.out.println("Item clicked.");
		System.out.println(item + "added to order");
	}
	
}
