package UI;

import application.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Global;
import application.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class employeeRequisition implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Product> tableView = new TableView<Product>();
	@FXML
	TableColumn<Product, String> desc = new TableColumn<>();
	@FXML
	TableColumn<Product, String> date = new TableColumn<>();
	@FXML
	TableColumn<Product, Integer> suppid = new TableColumn<>();
	@FXML
	TableColumn<Product, Integer> prodid = new TableColumn<>();

	@FXML
	Label mylabel = new Label();

	@FXML
	TextField product = new TextField();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		desc.setCellValueFactory(new PropertyValueFactory<>("ProductDesc"));
		date.setCellValueFactory(new PropertyValueFactory<>("MaunfacturedDate"));
		suppid.setCellValueFactory(new PropertyValueFactory<>("SuppID"));
		prodid.setCellValueFactory(new PropertyValueFactory<>("ProductID"));

		tableView.getColumns().clear();
		tableView.getColumns().add(suppid);
		tableView.getColumns().add(prodid);
		tableView.getColumns().add(desc);
		tableView.getColumns().add(date);

		String[] stringarray = Global.store.DisplayProductsUI().split("\n");
		String match = "";

		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			match = tokens[2];
			if (!tokens[0].equals("")) {
				tableView.getItems().add(
						new Product(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
			}
		}

	}

	public void switchTomenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void Request(ActionEvent event) throws IOException {

		int productid = Integer.parseInt(product.getText());
		int id = 0;
		for (int i = 0; i < Global.store.Supp.size(); i++) {

			for (int j = 0; j < Global.store.Supp.get(i).Products.size(); j++) {

				if (Global.store.Supp.get(i).Products.get(j).getProductID() == productid) {
					id = productid;
				}
			}
		}

		if (id == productid) {
			Global.store.ProductRequest(productid);
			mylabel.setText("Product ID: " + productid + " request successfully sent.");
		} else {
			mylabel.setText("Product ID: " + productid + " does not exist");
		}

	}

	public void switchToHome(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void logout(MouseEvent event) throws IOException {

		Global.store.LogoutID();
		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
