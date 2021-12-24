package UI;
import application.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menu implements Initializable {
    
	private Stage stage;
	private Scene scene;
	private Parent root; 
	
    @FXML
    private ImageView Exit;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;
    
    @FXML
    private Pane pane;
    
    @FXML
    private Button equipment;
    
    @FXML
    private Button profile;
    
    @FXML
    private Button Department;
   
    
    
    @Override
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
            
            slide.setOnFinished((ActionEvent e)-> {
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
            slide.setOnFinished((ActionEvent e)-> {
            	pane.setTranslateX(-80);
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }
    
    public void switchToEquipment(MouseEvent event) throws IOException {
    	
    
    	
    	
		root = FXMLLoader.load(getClass().getResource("equipmentMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    
    public void switchToprofile(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addProfileMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    public void switchToDepartment(MouseEvent event) throws IOException {
    	
  
		root = FXMLLoader.load(getClass().getResource("DeptList.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    public void switchToReport(MouseEvent event) throws IOException {
		
  		root = FXMLLoader.load(getClass().getResource("ReportMenu.fxml"));
  		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
  		scene = new Scene(root);
  		stage.setScene(scene);
  		stage.show();
      }
     
    public void switchToRecord(MouseEvent event) throws IOException {
    	
 		root = FXMLLoader.load(getClass().getResource("IssuanceRecordEquip.fxml"));
 		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 		scene = new Scene(root);
 		stage.setScene(scene);
 		stage.show();
     }
    
 public void switchToWorkers(MouseEvent event) throws IOException {
    	
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
 
    @FXML
    private Button button;
    @FXML
    private AnchorPane container;
    @FXML
    
    private void loadabout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getWidth());

        AnchorPane parentContainer = (AnchorPane) button.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.8), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();
    }
    
    @FXML
    private Button contact;
    @FXML
    private Pane container1;
    @FXML
    
    private void loadcontact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contactus.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getWidth());

        AnchorPane parentContainer = (AnchorPane) button.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.8), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();
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
