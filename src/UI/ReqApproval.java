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

public class ReqApproval implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<RequisitionApproval> tableView = new TableView<RequisitionApproval>();
	@FXML
	TableColumn<RequisitionApproval, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<RequisitionApproval, Integer> RequisitionID = new TableColumn<>();
	@FXML
	TableColumn<RequisitionApproval, Integer> SuppID = new TableColumn<>();
	@FXML
	TableColumn<RequisitionApproval, String> Status = new TableColumn<>();
	@FXML
	TableColumn<RequisitionApproval, String> IssueDate = new TableColumn<>();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		RequisitionID.setCellValueFactory(new PropertyValueFactory<>("RequisitionID"));
		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		SuppID.setCellValueFactory(new PropertyValueFactory<>("SuppID"));
		Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
		IssueDate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));

		tableView.getColumns().clear();
		tableView.getColumns().add(RequisitionID);
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(SuppID);
		tableView.getColumns().add(Status);
		tableView.getColumns().add(IssueDate);

		String[] stringarray = Global.store.ReqAprovals().split("\n");
		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			if (!tokens[0].equals("")) {
				tableView.getItems().add(new RequisitionApproval(Integer.parseInt(tokens[0]),
						Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
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