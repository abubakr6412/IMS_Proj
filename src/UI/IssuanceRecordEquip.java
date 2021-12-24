package UI;

import application.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class IssuanceRecordEquip implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<IssuanceRecord> tableView = new TableView<IssuanceRecord>();
	@FXML
	TableColumn<IssuanceRecord, Integer> RecordID = new TableColumn<>();
	@FXML
	TableColumn<IssuanceRecord, Integer> EquipmentID = new TableColumn<>();
	@FXML
	TableColumn<IssuanceRecord, Integer> EmpID = new TableColumn<>();
	@FXML
	TableColumn<IssuanceRecord, String> IssueDate = new TableColumn<>();
	@FXML
	TableColumn<IssuanceRecord, String> ReturnDate = new TableColumn<>();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		RecordID.setCellValueFactory(new PropertyValueFactory<>("RecordID"));
		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EQID"));
		EmpID.setCellValueFactory(new PropertyValueFactory<>("EMPID"));
		IssueDate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
		ReturnDate.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));

		tableView.getColumns().clear();
		tableView.getColumns().add(RecordID);
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(EmpID);
		tableView.getColumns().add(IssueDate);
		tableView.getColumns().add(ReturnDate);

		String[] stringarray = Global.store.DisplayDeptISRUI().split("\n");
		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			if (!tokens[0].equals("")) {
				tableView.getItems().add(new IssuanceRecord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
			}
		}

	}

	public void switchToSelect(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
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
