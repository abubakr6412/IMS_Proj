package UI;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.time.format.DateTimeFormatter;

import application.Global;

public class EmployeeAdd {
	
	private Stage stage;
	private Scene scene;
	private Parent root; 
	

	@FXML
	private TextField ID = new TextField();
	@FXML
	private TextField name = new TextField();
	@FXML
	private TextField age = new TextField();
	@FXML
	private TextField phonenumber = new TextField();
	@FXML
	private TextField address = new TextField();
	@FXML
	private TextField deptid = new TextField();
	@FXML
	private DatePicker myDatePicker;
	@FXML
	private DatePicker myDatePicker2;
	private String myFormattedDate;
	private String myFormattedDate2;
	
	@FXML
	private Label myLabel = new Label();
	@FXML
	private Button Go;
	
	public void StoreData(ActionEvent event) {

		LocalDate myDate = myDatePicker.getValue();
		myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		LocalDate myDate2 = myDatePicker2.getValue();
		myFormattedDate2 = myDate2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		int id = Integer.parseInt(ID.getText());
		int Age = Integer.parseInt(age.getText());
		int phon = Integer.parseInt(phonenumber.getText());
		String Name = name.getText();
		String Address = address.getText();
		int DeptID = Integer.parseInt(deptid.getText());
		
		Global.store.AddtoEmployee(id,DeptID,phon,Age,Name,Address,myFormattedDate,myFormattedDate2);
		
	}
	
	public void profile(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("addprofileEmployee.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

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
