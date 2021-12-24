package UI;
import application.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WindowLogin extends Application implements Runnable, Initializable {

	

	public static equipmentMenu equipment;

	private Stage stage;
	private Scene scene;
	private Parent root;
	double x = 0, y = 0;

	

	@FXML
	private Text invetory = new Text();
	@FXML
	private Text management = new Text();
	@FXML
	private Text system = new Text();
	@FXML
	private Text noAccount = new Text();
	@FXML
	private Text noAccount1 = new Text();
	@FXML
	private Text log = new Text();
	@FXML
	private Button signup = new Button();
	@FXML
	private Button login = new Button();
	@FXML
	private TextField username = new TextField();
	@FXML
	private PasswordField password = new PasswordField();
	@FXML
	private Text invetory1 = new Text();;
	@FXML
	private Text management1 = new Text();;
	@FXML
	private Text system1 = new Text();;
	@FXML
	private Text sign = new Text();;
	@FXML
	private Button signup2 = new Button();
	@FXML
	private Button login2 = new Button();
	@FXML
	private ImageView image = new ImageView();;
	@FXML
	private ImageView img = new ImageView();;
	@FXML
	private ImageView img1 = new ImageView();;
	@FXML
	private ImageView use = new ImageView();;
	@FXML
	private ImageView pass = new ImageView();;
	@FXML
	private ImageView image1 = new ImageView();;
	@FXML
	private ImageView use1 = new ImageView();;
	@FXML
	private ImageView pass1 = new ImageView();;
	@FXML
	private TextField username1 = new TextField();;
	@FXML
	private TextField password1 = new TextField();;
	@FXML
	private TextField email = new TextField();;
	@FXML
	private ImageView emailicon = new ImageView();
	@FXML
	private AnchorPane layer1 = new AnchorPane();
	@FXML
	private AnchorPane layer2 = new AnchorPane();
	@FXML
	private Label wrongpass = new Label();
	@FXML
	private Label create = new Label();
	@FXML
	private TextField deptfield = new TextField();
	@FXML
	private ImageView deptimage = new ImageView();;

	String Username;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		invetory.setVisible(true);
		management.setVisible(true);
		system.setVisible(true);
		noAccount.setVisible(true);
		log.setVisible(true);
		signup.setVisible(true);
		login.setVisible(true);
		image.setVisible(true);
		use.setVisible(true);
		pass.setVisible(true);
		username.setVisible(true);
		password.setVisible(true);
		create.setVisible(false);
		invetory1.setVisible(false);
		management1.setVisible(false);
		deptfield.setVisible(false);
		deptimage.setVisible(false);
		system1.setVisible(false);
		login2.setVisible(false);
		image1.setVisible(false);
		use1.setVisible(false);
		pass1.setVisible(false);
		username1.setVisible(false);
		password1.setVisible(false);
		email.setVisible(false);
		emailicon.setVisible(false);
		noAccount1.setVisible(false);
		sign.setVisible(false);
		signup2.setVisible(false);
		wrongpass.setVisible(true);
	}

	@FXML
	private void signupbutton(MouseEvent event) {

		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.7));
		slide.setNode(layer1);

		slide.setToX(491);
		slide.play();

		layer2.setTranslateX(-750);
		invetory.setVisible(false);
		management.setVisible(false);
		system.setVisible(false);
		noAccount.setVisible(false);
		log.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		image.setVisible(false);
		use.setVisible(false);
		pass.setVisible(false);
		username.setVisible(false);
		password.setVisible(false);
		wrongpass.setVisible(false);

		deptfield.setVisible(true);
		deptimage.setVisible(true);
		create.setVisible(true);
		img.setVisible(true);
		invetory1.setVisible(true);
		management1.setVisible(true);
		system1.setVisible(true);
		login2.setVisible(true);
		image1.setVisible(true);
		use1.setVisible(true);
		pass1.setVisible(true);
		username1.setVisible(true);
		password1.setVisible(true);
		email.setVisible(true);
		emailicon.setVisible(true);
		noAccount1.setVisible(true);
		sign.setVisible(true);
		signup2.setVisible(true);

		username.setText("");
		password.setText("");
		wrongpass.setText("");

		slide.setOnFinished((e -> {

		}));
	}

	@FXML
	private void loginbutton(MouseEvent event) {

		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.7));
		slide.setNode(layer1);

		slide.setToX(0);
		slide.play();

		layer2.setTranslateX(0);
		invetory.setVisible(true);
		management.setVisible(true);
		system.setVisible(true);
		noAccount.setVisible(true);
		log.setVisible(true);
		signup.setVisible(true);
		login.setVisible(true);
		image.setVisible(true);
		use.setVisible(true);
		pass.setVisible(true);
		username.setVisible(true);
		password.setVisible(true);
		img.setVisible(true);
		wrongpass.setVisible(true);

		create.setVisible(false);
		deptfield.setVisible(false);
		deptimage.setVisible(false);
		invetory1.setVisible(false);
		management1.setVisible(false);
		system1.setVisible(false);
		login2.setVisible(false);
		image1.setVisible(false);
		use1.setVisible(false);
		pass1.setVisible(false);
		username1.setVisible(false);
		password1.setVisible(false);
		email.setVisible(false);
		emailicon.setVisible(false);
		noAccount1.setVisible(false);
		sign.setVisible(false);
		signup2.setVisible(false);

		slide.setOnFinished((e -> {

		}));
	}

	public void CheckLogin(MouseEvent event) throws IOException {

		Global.store.SystemLL(username.getText(), password.getText());
		
		// Supplier Login
		if (Global.store.SystemLogin(username.getText(), password.getText()) == 1) {

			SupplierMenu menu1 = new SupplierMenu();
			
			root = FXMLLoader.load(getClass().getResource("SupplierMenu.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		// Inventory Clerk Login
		if (Global.store.SystemLogin(username.getText(), password.getText()) == 2) {

			menu menu1 = new menu();
			

			root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		// Employee Login
		if (Global.store.SystemLogin(username.getText(), password.getText()) == 3) {

			EmployeeMenu menu1 = new EmployeeMenu();
			

			root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		if (Global.store.SystemLogin(username.getText(), password.getText()) != 1
				&& Global.store.SystemLogin(username.getText(), password.getText()) != 2
				&& Global.store.SystemLogin(username.getText(), password.getText()) != 3) {
			wrongpass.setText("Username or Password are Incorrect!");
		}
	}

	// ---------------------------------------Sign
	// Up------------------------------------------

	public void signup(MouseEvent event) throws IOException {

		int ID = Integer.parseInt(email.getText());
		String username = username1.getText();
		String password = password1.getText();
		int deptID = Integer.parseInt(deptfield.getText());

		boolean test = false;

		for (int i = 0; i < Global.store.Depts.size(); i++) {
			for (int j = 0; j < Global.store.Depts.get(i).IC.AccApprovals.size(); j++) {
				if (Global.store.Depts.get(i).getID() == deptID) {
					if (Global.store.Depts.get(i).IC.AccApprovals.get(j).getUsername().equals(username)) {
						test = true;
					}
				}
			}
		}

		if (test == true) {
			create.setText("Account already exists.Kindly contact support.");
		} else {
			Global.store.AddtoAccountApproval(ID, username, password, deptID);
			create.setText("Account Created.Wait for Approval!");
		}

		Global.store.DisplayAccountApprovals();

	}

	// ---------------------------------------------------------------------------------------

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = new Stage();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		launch();
	}

	public void hide() {
		stage.hide();
	}


	// -------------------------------------View
	// Equipment--------------------------------

	@FXML
	private Button select = new Button();
	@FXML
	private Button all = new Button();
	@FXML
	private Label view1 = new Label();

	public void switchToSelect(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("ViewSelect.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToonlySelect(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("SelectedEquipment.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchTomenu1(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("equipmentMenu.fxml"));
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

	// -------------------------------------Request
	// Equipment--------------------------------
	public void switchTomenuequip(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("equipmentMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}