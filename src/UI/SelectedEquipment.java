package UI;

import java.io.IOException;

import application.Equipment;
import application.EquipmentDescription;
import application.Global;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SelectedEquipment {

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
	TableView<EquipmentDescription> tableView2 = new TableView<EquipmentDescription>();
	@FXML
	TableColumn<EquipmentDescription, String> Desc = new TableColumn<>();
	@FXML
	TableColumn<EquipmentDescription, String> Comp = new TableColumn<>();
	

	@FXML
	private TextField EquipID = new TextField();

	public void ViewSelect(MouseEvent event) {

		EquipmentID.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
		DeptID.setCellValueFactory(new PropertyValueFactory<>("DeptID"));
		Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
		Condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));
		
		Desc.setCellValueFactory(new PropertyValueFactory<>("Description"));
		Comp.setCellValueFactory(new PropertyValueFactory<>("Company"));

		tableView.getColumns().clear();
		tableView.getColumns().add(EquipmentID);
		tableView.getColumns().add(DeptID);
		tableView.getColumns().add(Price);
		tableView.getColumns().add(Condition);
		

		tableView2.getColumns().clear();
		tableView2.getColumns().add(Desc);
		tableView2.getColumns().add(Comp);
		
		String match = "";

		String[] stringarray = Global.store.DisplayEquipmentsUI().split("\n");
		String[] stringarray2 = Global.store.EquipmentDescription().split("\n");
		
		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			if (!tokens[0].equals("")) {
				match = tokens[0];
				if (tokens[0].equals(EquipID.getText())) {
					tableView.getItems().add(new Equipment(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]), tokens[3]));
					
					for(int j = 0; j < stringarray2.length; j++)
					{
						String[] tokens1= stringarray2[j].split(",");
						if(match.equals(tokens1[0]))
						{
							tableView2.getItems().add(new EquipmentDescription(Integer.parseInt(tokens1[0]),tokens1[1],
									tokens1[2]));
						}
					}
				}
			}
		}
	}

	public void switchToSelect(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ViewEquipment.fxml"));
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
