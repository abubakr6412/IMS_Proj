package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AccountApproval;
import application.Global;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class accountApprovalUI implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TableView<AccountApproval> tableView = new TableView<AccountApproval>();
	@FXML
	TableColumn<AccountApproval, String> Username = new TableColumn<>();
	@FXML
	TableColumn<AccountApproval, String> Pass = new TableColumn<>();
	@FXML
	TableColumn<AccountApproval, Integer> ID = new TableColumn<>();
	@FXML
	TableColumn<AccountApproval, Integer> DeptID = new TableColumn<>();

	@FXML
	Label mylabel = new Label();

	@FXML
	TextField ApprovalField = new TextField();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
		Pass.setCellValueFactory(new PropertyValueFactory<>("Pass"));
		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		DeptID.setCellValueFactory(new PropertyValueFactory<>("DeptID"));

		tableView.getColumns().clear();
		tableView.getColumns().add(Username);
		tableView.getColumns().add(Pass);
		tableView.getColumns().add(ID);
		tableView.getColumns().add(DeptID);

		String[] stringarray = Global.store.DisplayAccountApprovalsUI().split("\n");
		String match = "";

		for (int i = 0; i < stringarray.length; i++) {
			String[] tokens = stringarray[i].split(",");
			match = tokens[2];
			if (Integer.parseInt(tokens[3]) == Global.store.GetID()) {
				tableView.getItems().add(new AccountApproval(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
						Integer.parseInt(tokens[3])));
			}
		}
	}

	public void switchTomenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("workers.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void Approval(ActionEvent event) throws IOException {

		int id = Integer.parseInt(ApprovalField.getText());
		if (id == Global.store.getAccountaprrovalID()) {
			Global.store.AccountApproved(id);
			mylabel.setText("ID: " + id + " successfully approved.");
		}
		else
		{
			mylabel.setText("ID: " + id + " does not exist.");
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
