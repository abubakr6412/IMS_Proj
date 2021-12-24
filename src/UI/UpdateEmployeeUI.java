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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateEmployeeUI implements Initializable{

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
	private TextField age = new TextField("");
	@FXML
	private TextField phone = new TextField("");
	@FXML
	private TextField address = new TextField("");
	@FXML
	private TextField dob = new TextField("");
	
	
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

				
		for(int i = 0;i < stringarray.length; i++)
		{
			String[] tokens  = stringarray[i].split(",");
			if(tokens[0].equals(String.valueOf(Global.store.ActiveLoginID()))){
			tableView.getItems().add(new Employee(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6],tokens[7]));
		    }
		}
		
	}
	
	public void switchToMenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addprofileEmployee.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void update(MouseEvent event) throws IOException {
		
		String phonenum =(phone.getText());
		String age1 = (age.getText());
		String addr = address.getText();
		String dob1 = dob.getText();
	    
		if(phonenum.equals("") && age1.equals(""))
		{
			Global.store.UpdateEmployeeDetails(0,0,addr,dob1);
		}
		else if(phonenum.equals(""))
		{
			Global.store.UpdateEmployeeDetails(0,Integer.parseInt(age1),addr,dob1);
		}
		else if(age1.equals(""))
		{
			Global.store.UpdateEmployeeDetails(Integer.parseInt(phonenum),0,addr,dob1);
		}
		else
		{
			Global.store.UpdateEmployeeDetails(Integer.parseInt(phonenum),Integer.parseInt(age1),addr,dob1);
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
