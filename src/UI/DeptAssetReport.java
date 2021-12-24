package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Equipment;
import application.EquipmentDescription;
import application.Global;
import application.IssuanceRecord;
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

public class DeptAssetReport {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Equipment> tableView = new TableView<Equipment>();
	@FXML
	TableColumn<Equipment, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<Equipment, Integer> Price = new TableColumn<>();
	@FXML
	TableColumn<Equipment, String> Condition = new TableColumn<>();

	@FXML
	TableView<EquipmentDescription> tableView1 = new TableView<EquipmentDescription>();
	@FXML
	TableColumn<EquipmentDescription, String> Description = new TableColumn<>();
	@FXML
	TableColumn<EquipmentDescription, String> Company = new TableColumn<>();

	@FXML
	TableView<IssuanceRecord> tableView2 = new TableView<IssuanceRecord>();
	@FXML
	TableColumn<IssuanceRecord, String> IssueDate = new TableColumn<>();

	@FXML
	Label mylabel = new Label();

	@FXML
	TextField ApprovalField = new TextField();

	public void view(MouseEvent event) throws IOException {

		int id = Integer.parseInt(ApprovalField.getText());

		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
		Condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

		Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
		Company.setCellValueFactory(new PropertyValueFactory<>("Company"));

		IssueDate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));

		tableView.getColumns().clear();
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(Price);
		tableView.getColumns().add(Condition);

		tableView1.getColumns().clear();
		tableView1.getColumns().add(Description);
		tableView1.getColumns().add(Company);

		tableView2.getColumns().clear();
		tableView2.getColumns().add(IssueDate);

		String[] stringarray = Global.store.DisplayEquipmentsUI().split("\n");
		String[] stringarray1 = Global.store.EquipmentDescription().split("\n");

		String match = "";
		int price = 0;

		for (int n = 0; n < stringarray.length; n++) {

			String[] tokens = stringarray[n].split(",");
			System.out.println(stringarray[n] + "array");
			System.out.println(tokens[1]);
			if (Integer.parseInt(tokens[1]) == id) {
				match = tokens[0];
				tableView.getItems().add(new Equipment(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]), tokens[3]));
				price += Integer.parseInt(tokens[2]);

				for (int l = 0; l < stringarray1.length; l++) {
					String[] tokens1 = stringarray1[l].split(",");
					// System.out.println(tokens1[0]);
					if (match.equals(tokens1[0])) {

						tableView1.getItems()
								.add(new EquipmentDescription(Integer.parseInt(tokens1[0]), tokens1[1], tokens1[2]));

					}
				}

			}

		}

		mylabel.setText(String.valueOf(price));

	}

	public void switchTomenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ReportMenu.fxml"));
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
