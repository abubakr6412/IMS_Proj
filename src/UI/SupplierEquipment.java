package UI;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Global;

public class SupplierEquipment implements Initializable {

	
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private ImageView Exit=new ImageView();

	@FXML
	private Label Menu=new Label();

	@FXML
	private Label MenuClose=new Label();

	@FXML
	private AnchorPane slider=new AnchorPane();

	@FXML
	private Pane pane=new Pane();
	
	@FXML
	private Button requEuip=new Button();
	

	//@Override
	public void initialize(URL location, ResourceBundle resources) {

		Exit.setOnMouseClicked(event -> {
			System.exit(0);
		});
		slider.setTranslateX(-200);
		pane.setTranslateX(-80);
		Menu.setOnMouseClicked(event -> {
			TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.4));
			slide.setNode(slider);

			slide.setToX(0);
			slide.play();

			slider.setTranslateX(-200);

			slide.setOnFinished((ActionEvent e) -> {
				Menu.setVisible(false);
				MenuClose.setVisible(true);
				pane.setTranslateX(0);
			});
		});

		MenuClose.setOnMouseClicked(event -> {
			TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.4));
			slide.setNode(slider);

			slide.setToX(-200);
			slide.play();

			slider.setTranslateX(0);
			slide.setOnFinished((ActionEvent e) -> {
				pane.setTranslateX(-80);
				Menu.setVisible(true);
				MenuClose.setVisible(false);
			});
		});
	}

	public void switchTomenu(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SupplierMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToEquipment(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ViewSupplierEquipment.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchTorequestequip(MouseEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("CheckDelivery.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
