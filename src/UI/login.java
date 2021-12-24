package UI;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class login implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	double x = 0,y = 0;
	
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
	private Button signup  = new Button();
	@FXML
	private Button login  = new Button();
	@FXML
	private TextField username= new TextField();
	@FXML
	private TextField password= new TextField();
	@FXML
	private Text invetory1= new Text();;
	@FXML
	private Text management1= new Text();;
	@FXML
	private Text system1= new Text();;
	@FXML
	private Text sign= new Text();;
	@FXML
	private Button signup2  = new Button();
	@FXML
	private Button login2  = new Button();
	@FXML
	private ImageView image= new  ImageView();;
	@FXML
	private ImageView img= new  ImageView();;
	@FXML
	private ImageView img1= new  ImageView();;
	@FXML
	private ImageView use= new  ImageView();;
	@FXML
	private ImageView pass= new  ImageView();;
	@FXML
	private ImageView image1= new  ImageView();;
	@FXML
	private ImageView use1= new  ImageView();;
	@FXML
	private ImageView pass1= new  ImageView();;
	@FXML
	private TextField username1= new TextField();;
	@FXML
	private TextField password1= new TextField();;
	@FXML
	private TextField email= new TextField();;
	@FXML
	private ImageView emailicon= new  ImageView();
	@FXML
	private AnchorPane layer1= new  AnchorPane();
	@FXML
	private AnchorPane layer2= new  AnchorPane();

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
	
	public void switchToScene(MouseEvent event1) throws IOException {
		
		 
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
