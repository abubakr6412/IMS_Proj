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

public class UpdateSupplier implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
	TableView<Supplier> tableView = new TableView<Supplier>();
	@FXML
    TableColumn<Supplier, Integer> SupplierID = new TableColumn<>();
	@FXML
    TableColumn<Supplier, Integer> Company = new TableColumn<>();
	@FXML
    TableColumn<Supplier, Integer> PNo = new TableColumn<>();
	@FXML
    TableColumn<Supplier, Integer> Age = new TableColumn<>();
	@FXML
    TableColumn<Supplier, String> Name = new TableColumn<>();
	@FXML
    TableColumn<Supplier, String> Address = new TableColumn<>();
	@FXML
    TableColumn<Supplier, String> JoinDate = new TableColumn<>();
	
	@FXML
	private TextField age = new TextField("");
	@FXML
	private TextField phone = new TextField("");
	@FXML
	private TextField address = new TextField("");
	@FXML
	private TextField comapny = new TextField("");
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		SupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
		Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		PNo.setCellValueFactory(new PropertyValueFactory<>("PNo"));
		Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
		Company.setCellValueFactory(new PropertyValueFactory<>("Company"));
		Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
		JoinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
		
		 tableView.getColumns().clear();
		 tableView.getColumns().add(SupplierID);
		 tableView.getColumns().add(Name);
		 tableView.getColumns().add(PNo);
		 tableView.getColumns().add(Age);
		 tableView.getColumns().add(Company);
		 tableView.getColumns().add(Address);
		 tableView.getColumns().add(JoinDate);
		 
		String[] stringarray = Global.store.DisplaySupplierUI().split("\n");
				
		for(int i = 0;i < stringarray.length; i++)
		{
			String[] tokens  = stringarray[i].split(",");
			if(tokens[1].equals(String.valueOf(Global.store.ActiveLoginID()))){
			tableView.getItems().add(new Supplier(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),tokens[4],tokens[5],tokens[6]));
		    }
		}
		
	}
	
	public void switchToMenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SupplierProfile.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void update(MouseEvent event) throws IOException {
		
		String phonenum =(phone.getText());
		String age1 = (age.getText());
		String addr = address.getText();
		String comp = comapny.getText();
	    
		if(phonenum.equals("") && age1.equals(""))
		{
			Global.store.UpdateSupplierDetails(0,0,addr,comp);
		}
		else if(phonenum.equals(""))
		{
			Global.store.UpdateSupplierDetails(0,Integer.parseInt(age1),addr,comp);
		}
		else if(age1.equals(""))
		{
			Global.store.UpdateSupplierDetails(Integer.parseInt(phonenum),0,addr,comp);
		}
		else
		{
			Global.store.UpdateSupplierDetails(Integer.parseInt(phonenum),Integer.parseInt(age1),addr,comp);
		}
		
		
		
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
