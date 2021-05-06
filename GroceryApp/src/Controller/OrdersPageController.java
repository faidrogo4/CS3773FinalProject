package Controller;

import Model.History;
import Model.Order;
import Model.Product;
import application.Main;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

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
	public TableView<Product> tableview;
	@FXML
	public TableColumn<Product, String> nameColumn;
	@FXML
	public TableColumn<Product, Integer> quantityColumn;
	@FXML
	public TableColumn<Product, Double> priceColumn;


	public ArrayList<TableView> tableHist;



	@FXML
	public void initialize(){
		/*TESTDATA*
		Main.current.getOrder().AddProduct(new Product("Apple",1,1.00 ,2,0));
		Main.current.getOrder().AddProduct(new Product("Banana",2,2.00 ,2,0));
		Main.current.getOrder().AddProduct(new Product("Orange",1,1.50 ,1,0));
		Main.current.checkout();
		**/
		tableHist = new ArrayList<>();

		History custHist=new History(Main.current.getHist().getClone());
		Order nextOrder = custHist.popOrder();
		while(nextOrder!=null){
			orderNumber.setText(""+nextOrder.getOrderNum());
			tableview.setItems(nextOrder.getObservable());
			tableHist.add(new TableView(nextOrder.getObservable()));
			nextOrder=custHist.popOrder();

		}

	}



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

	public void nextOrder(final ActionEvent actionEvent) {
		int currentNum =Integer.parseInt(orderNumber.getText());
		int maxNum=Main.current.getOrderNum();
		if(currentNum<=maxNum-1){
			tableview=tableHist.get(currentNum);
			orderNumber.setText(""+(currentNum+1));
		}
	}

	public void prevOrder(final ActionEvent actionEvent) {
		int currentNum =Integer.parseInt(orderNumber.getText());
		if(currentNum>1){
			tableview=tableHist.get(currentNum-2);
			orderNumber.setText(""+(currentNum-1));
		}
	}
}
