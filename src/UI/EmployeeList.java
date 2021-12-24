package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Employee;
import application.Global;
import application.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmployeeList implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<Employee> tableView = new TableView<Employee>();
	@FXML
	TableColumn<Employee, Integer> EMPID = new TableColumn<>();
	@FXML
	TableColumn<Employee, Integer> DeptID = new TableColumn<>();
	@FXML
	TableColumn<Employee, Integer> PNo = new TableColumn<>();
	@FXML
	TableColumn<Employee, Integer> Age = new TableColumn<>();
	@FXML
	TableColumn<Employee, String> Name = new TableColumn<>();
	@FXML
	TableColumn<Employee, String> Address = new TableColumn<>();
	@FXML
	TableColumn<Employee, String> JoinDate = new TableColumn<>();
	@FXML
	TableColumn<Employee, String> DOB = new TableColumn<>();

	@FXML
	TextField rem = new TextField();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		EMPID.setCellValueFactory(new PropertyValueFactory<>("EMPID"));
		Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		PNo.setCellValueFactory(new PropertyValueFactory<>("PNo"));
		Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
		DeptID.setCellValueFactory(new PropertyValueFactory<>("DeptID"));
		Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
		JoinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
		DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));

		tableView.getColumns().clear();
		tableView.getColumns().add(EMPID);
		tableView.getColumns().add(Name);
		tableView.getColumns().add(PNo);
		tableView.getColumns().add(Age);
		tableView.getColumns().add(DeptID);
		tableView.getColumns().add(Address);
		tableView.getColumns().add(JoinDate);
		tableView.getColumns().add(DOB);

		String[] stringarray = Global.store.DisplayEmployeeUI().split("\n");
		for (int i = 0; i < stringarray.length; i++) {
			
				String[] tokens = stringarray[i].split(",");
				if (Integer.parseInt(tokens[1]) == Global.store.GetID()) {
				tableView.getItems()
						.add(new Employee(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
								Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4], tokens[5],
								tokens[6], tokens[7]));
			}
		}
	}

	public void delete(MouseEvent event) {
		int id = Integer.parseInt(rem.getText());
	}

	public void switchToMenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("workers.fxml"));
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