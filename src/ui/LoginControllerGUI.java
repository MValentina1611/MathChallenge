package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;

public class LoginControllerGUI {

	//@FXML Attributes 
	@FXML
	private TextField txtNameLogin;

	@FXML
	private Button btnStart;

	 //Attributes   
	private Stage loginStage;
	
	private Player player;
	private QuestionsControllerGUI questions;
	//Builder
    
	public LoginControllerGUI() 
	{
		loginStage = new Stage();
		questions = new QuestionsControllerGUI(this);
	}

	//Methods
	public  void showLogin( Pane mainPane ) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.setTitle("Log in");
		loginStage.show(); 

	}   

	// @FXML Methods
    @FXML
    public void startGame(ActionEvent event) throws IOException {
    	
    	if(txtNameLogin.getText().isEmpty())
    	{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning dialog");
			alert.setHeaderText(null);
			alert.setContentText("Please, type your name");
			alert.showAndWait();
    	}else
    	{
    		player = new Player(txtNameLogin.getText());
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("questions.fxml"));
    		fxmlLoader.setController(questions);
    		Parent root = fxmlLoader.load();
    		Scene scene = new Scene(root);
    		loginStage.setScene(scene);
    		loginStage.setTitle("Questions");
    		loginStage.show(); 
    	//	questions.getLabName().setText(player.getName());
    	//	questions.getLabScore().setText(String.valueOf(player.getScore()));
    	//	questions.showQuestions();
    	}
    }


	public Player getPlayer() {
		return player;
	}

	public void setTxtNameLogin(TextField txtNameLogin) {
		this.txtNameLogin = txtNameLogin;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Stage getLoginStage() {
		return loginStage;
	}
    
	
    
    
    
}
