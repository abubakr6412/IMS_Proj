package UI;

import application.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class Requsitionslist implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Requisition> tableView = new TableView<Requisition>();
	@FXML
	TableColumn<Requisition, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<Requisition, Integer> DeptID = new TableColumn<>();
	@FXML
	TableColumn<Requisition, Integer> RequisitionID = new TableColumn<>();
	@FXML
	TableColumn<Requisition, Integer> EMPID = new TableColumn<>();

	@FXML
	TableView<Product> tableView1 = new TableView<Product>();
	@FXML
	TableColumn<Product, String> ProductDesc = new TableColumn<>();
	@FXML
	TableColumn<Product, String> MaunfacturedDate = new TableColumn<>();

	@FXML
	Label mylabel = new Label();

	@FXML
	TextField ApprovalField = new TextField();

	int id;
	int deptid;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		RequisitionID.setCellValueFactory(new PropertyValueFactory<>("RequisitionID"));
		EMPID.setCellValueFactory(new PropertyValueFactory<>("EMPID"));
		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		DeptID.setCellValueFactory(new PropertyValueFactory<>("DeptID"));
		ProductDesc.setCellValueFactory(new PropertyValueFactory<>("ProductDesc"));
		MaunfacturedDate.setCellValueFactory(new PropertyValueFactory<>("MaunfacturedDate"));

		tableView.getColumns().clear();
		tableView.getColumns().add(RequisitionID);
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(DeptID);
		tableView.getColumns().add(EMPID);

		tableView1.getColumns().clear();
		tableView1.getColumns().add(ProductDesc);
		tableView1.getColumns().add(MaunfacturedDate);

		String[] stringarray = Global.store.Requisitions().split("\n");
		String[] stringarray1 = Global.store.DisplayProductsUI().split("\n");
		String match = "";

		for (int i = 0; i < stringarray.length; i++) {

			String[] tokens = stringarray[i].split(",");
			match = tokens[2];
			if (!tokens[0].equals("")) {
				if (Integer.parseInt(tokens[3]) == Global.store.GetID()) {
					id = Integer.parseInt(tokens[1]);
					deptid = Integer.parseInt(tokens[3]);
					tableView.getItems().add(new Requisition(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[0]), Integer.parseInt(tokens[3])));

					for (int j = 0; j < stringarray1.length; j++) {
						String[] tokens1 = stringarray1[j].split(",");
						if (match.equals(tokens1[1])) {
							tableView1.getItems().add(new Product(Integer.parseInt(tokens1[0]),
									Integer.parseInt(tokens1[1]), tokens1[2], tokens1[3]));
						}
					}
				}
			}
		}

	}

	public void switchTomenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("equipmentMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void Approval(ActionEvent event) throws IOException {

		int reqip = Integer.parseInt(ApprovalField.getText());

		if (Global.store.GetID() == deptid && reqip == id) {
			Global.store.ApproveRequisition(reqip);
			mylabel.setText("Requisiton ID: " + reqip + " successfully approved.");
		} else {
			mylabel.setText("Requisiton ID: " + reqip + " is either not in your Department or it doesn't Exist");
		}

	}
   
	public void switchToHome(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
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
