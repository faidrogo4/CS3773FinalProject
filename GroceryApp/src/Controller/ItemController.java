package Controller;

import Model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXButton;

public class ItemController {

	@FXML
	private Label nameLabel;
	
	@FXML 
	private Label priceLabel;
	
	@FXML
	private ImageView itemImage;
	
	@FXML
	public JFXButton addToCartButton;
	
	private Product item;
	
	public void setData(Product item) {
		this.item = item;
		nameLabel.setText(item.GetPName());
		priceLabel.setText("$" + item.GetPrice());
		Image image = new Image(getClass().getResourceAsStream(item.GetPImgSrc()));
		itemImage.setImage(image);
	}
}
