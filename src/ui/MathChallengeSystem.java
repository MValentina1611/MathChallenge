package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Questions;
import model.ScoreBoard;

public class MathChallengeSystem extends Application{

	 @FXML
	 private Pane mainPane = new Pane();
	
	 private LoginControllerGUI login;
	
	 private static Questions quest;
	 
	 public MathChallengeSystem() throws IOException {
	
		login = new LoginControllerGUI();
		quest = new Questions();
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		login.showLogin(mainPane);	
	}
	
	public static void main(String[] args) {
		launch(args);
		
	
		quest.generateQuestionWithOptions();
	}
	

}
