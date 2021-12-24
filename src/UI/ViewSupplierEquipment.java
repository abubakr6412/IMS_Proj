package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Equipment;
import application.Global;
import application.RequisitionApproval;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewSupplierEquipment implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Equipment> tableView = new TableView<Equipment>();
	@FXML
	TableColumn<Equipment, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<Equipment, Integer> DeptID = new TableColumn<>();
	@FXML
	TableColumn<Equipment, Integer> Price = new TableColumn<>();
	@FXML
	TableColumn<Equipment, String> Condition = new TableColumn<>();

	@FXML
	TableView<RequisitionApproval> tableView2 = new TableView<RequisitionApproval>();
	@FXML
	TableColumn<RequisitionApproval, Integer> SuppID = new TableColumn<>();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		DeptID.setCellValueFactory(new PropertyValueFactory<>("DeptID"));
		Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
		Condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

		SuppID.setCellValueFactory(new PropertyValueFactory<>("SuppID"));

		tableView.getColumns().clear();
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(DeptID);
		tableView.getColumns().add(Price);
		tableView.getColumns().add(Condition);

		tableView2.getColumns().clear();
		tableView2.getColumns().add(SuppID);

		String[] stringarray = Global.store.DisplayEquipmentsUI().split("\n");



				for (int j = 0; j < stringarray.length; j++) {
					
					String[] tokens1 = stringarray[j].split(",");
						if (!tokens1[0].equals("")) {
							tableView.getItems().add(new Equipment(Integer.parseInt(tokens1[0]),
									Integer.parseInt(tokens1[1]), Integer.parseInt(tokens1[2]), tokens1[3]));
						
					}
				}
		

	}

	public void switchToSelect(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SupplierEquipment.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToHome(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SupplierMenu.fxml"));
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
