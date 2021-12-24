package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Department;
import application.Global;
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

public class DeptList implements Initializable{


	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	TableView<Department> tableView = new TableView<Department>();
	@FXML
    TableColumn<Department, Integer> DeptID = new TableColumn<>();
	@FXML
    TableColumn<Department, String> Name = new TableColumn<>();
	@FXML
    TableColumn<Department, String> Location = new TableColumn<>();
	@FXML
    TableColumn<Department, Integer> count = new TableColumn<>();
	
			
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		DeptID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
		count.setCellValueFactory(new PropertyValueFactory<>("PersonnelCount"));
		
		 tableView.getColumns().clear();
		 tableView.getColumns().add(DeptID);
		 tableView.getColumns().add(Name);
		 tableView.getColumns().add(Location);
		 tableView.getColumns().add(count);
		
		String[] stringarray = Global.store.DisplayDepartments1().split("\n");
		for(int i = 0;i < stringarray.length; i++)
		{
			String[] tokens  = stringarray[i].split(",");
			tableView.getItems().add(new Department(Integer.parseInt(tokens[0]),tokens[2],tokens[1],Integer.parseInt(tokens[3])));
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
