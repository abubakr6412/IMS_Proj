package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Global;
import application.Requisition;
import application.RequisitionApproval;
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

public class Allocate implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Requisition> tableView = new TableView<Requisition>();
	@FXML
	TableColumn<Requisition, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<Requisition, Integer> EMPID = new TableColumn<>();

	@FXML
	TableView<RequisitionApproval> tableView1 = new TableView<RequisitionApproval>();
	@FXML
	TableColumn<RequisitionApproval, String> IssueDate = new TableColumn<>();
	@FXML
	TableColumn<RequisitionApproval, String> Status = new TableColumn<>();

	@FXML
	TextField equip = new TextField();
	@FXML
	TextField issuedate = new TextField();
	@FXML
	TextField empid = new TextField();
	@FXML
	TextField returndate = new TextField();

	@FXML
	Label mylabel = new Label();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		EMPID.setCellValueFactory(new PropertyValueFactory<>("EMPID"));
		IssueDate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
		Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

		tableView.getColumns().clear();
		tableView.getColumns().add(EMPID);
		tableView.getColumns().add(EquipmentID);

		tableView1.getColumns().clear();
		tableView1.getColumns().add(IssueDate);
		tableView1.getColumns().add(Status);

		String[] stringarray = Global.store.Requisitions().split("\n");
		String[] stringarray1 = Global.store.ReqAprovals().split("\n");
		String match = "";

		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			match = tokens[1];
			if (!tokens[0].equals("")) {
				if (Global.store.GetStatus(Integer.parseInt(tokens[1])).equals("Delivered")) {
					tableView.getItems().add(new Requisition(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
				}

				for (int j = 0; j < stringarray1.length; j++) {
					String[] tokens1 = stringarray1[j].split(",");
					if (!tokens1[0].equals("")) {
					if (match.equals(tokens1[1])) {
							tableView1.getItems()
									.add(new RequisitionApproval(Integer.parseInt(tokens1[0]),
											Integer.parseInt(tokens1[1]), Integer.parseInt(tokens1[2]), tokens1[3],
											tokens1[4]));
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

	public void Allocateequip(MouseEvent event) {

		int eq = Integer.parseInt(equip.getText());
		int empid1 = Integer.parseInt(empid.getText());
		String issue = issuedate.getText();
		String returndate1 = returndate.getText();

		int id = 0;

		for (int i = 0; i < Global.store.Depts.size(); i++) {
			for (int j = 0; j < Global.store.Depts.get(i).EMP.size(); j++) {
				if (empid1 == Global.store.Depts.get(i).EMP.get(j).getEMPID()
						&& Global.store.Depts.get(i).EMP.get(j).getDeptID() == Global.store.GetID()) {
					id = empid1;
				}
			}

		}

		if (id == empid1) {
			Global.store.UpdateIssuanceRecord(eq, empid1, issue, returndate1);
			mylabel.setText("Allocated Succesfully");
		} else {
			mylabel.setText("Allocate Unsuccessfull");
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