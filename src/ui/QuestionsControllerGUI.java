package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.Questions;
import model.Timer;
import thread.TimerThread;

public class QuestionsControllerGUI {

	// @FXML Attributes 
	
	 @FXML
	    private Label labQuestion;

	    @FXML
	    private Label labClock;

	    @FXML
	    private Button btnOp1;

	    @FXML
	    private Button btnOp2;

	    @FXML
	    private Button btnOp3;

	    @FXML
	    private Button btnOp4;

	    @FXML
	    private Label labScore;

	    @FXML
	    private Label labName;

	    
	   // Attributes
	    private Questions questions;
	    private LoginControllerGUI loginGUI;
	    private TimerThread timerThread;
	    private Timer timer;
	    
	    //Builder
	    public QuestionsControllerGUI( LoginControllerGUI loginGUI)
	    {
	    	questions = new Questions();
	    	this.loginGUI = loginGUI;
	    	btnOp1 = new Button();
	    	btnOp2 = new Button();
	    	btnOp3 = new Button();
	    	btnOp4 = new Button();
	    	timer = new Timer();
	    	timerThread = new TimerThread(timer, this);
	    }
	    
	    
	    // Methods
	    
	    public void initialize() throws IOException
	    {
	    	labName.setText(loginGUI.getPlayer().getName());
	    	labScore.setText(String.valueOf(loginGUI.getPlayer().getScore()));
	    	showQuestions();
	    	timer.setRunning(true);
	    	timerThread.start();
	    	
	    }
	    
	    public void goToNextWindow() throws IOException
	    {

	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));
	    	fxmlLoader.setController(questions);
	    	Parent root = fxmlLoader.load();
	    	Scene scene = new Scene(root);
	    	loginGUI.getLoginStage().setScene(scene);
	    	loginGUI.getLoginStage().setTitle("ScoreBoard");
	    	loginGUI.getLoginStage().show();
	    	timer.setRunning(false);
	    }
	    
	    public void refreshTimerlabel()
	    {
	    	labClock.setText(String.valueOf(timer.getTime()));
	    }
	       
	    public void showQuestions()
	    {
	    	questions.generateQuestionWithOptions();

	    	labQuestion.setText(questions.getQuestion());

	    	int answerPos  = (int)(Math.random()*4+1);

	    	switch(answerPos)
	    	{
		    	case 1:
		    	{
		    		btnOp1.setText(String.valueOf(questions.getAnswer()));
		    		btnOp2.setText(String.valueOf(questions.getOp1()));
		    		btnOp3.setText(String.valueOf(questions.getOp2()));
		    		btnOp4.setText(String.valueOf(questions.getOp3()));
		    		break;
		    	}
	
		    	case 2:
		    	{
		    		btnOp2.setText(String.valueOf(questions.getAnswer()));
		    		btnOp1.setText(String.valueOf(questions.getOp1()));
		    		btnOp3.setText(String.valueOf(questions.getOp2()));
		    		btnOp4.setText(String.valueOf(questions.getOp3()));
		    		break;
		    	}
		    	case 3:
		    	{
		    		btnOp3.setText(String.valueOf(questions.getAnswer()));
		    		btnOp2.setText(String.valueOf(questions.getOp1()));
		    		btnOp1.setText(String.valueOf(questions.getOp2()));
		    		btnOp4.setText(String.valueOf(questions.getOp3()));
		    		break;
		    	}
	
		    	case 4:
		    	{
		    		btnOp4.setText(String.valueOf(questions.getAnswer()));
		    		btnOp2.setText(String.valueOf(questions.getOp1()));
		    		btnOp3.setText(String.valueOf(questions.getOp2()));
		    		btnOp1.setText(String.valueOf(questions.getOp3()));
		    		break;
		    	}
	    	}
	    }
	    
	    public boolean verifyCorrectAnswer(int op)
	    {
	    	boolean equals = false;
	    	if(op == questions.getAnswer())
	    	{
	    		equals = true;
	    	}
	    	
	    	return equals;
	    }
	    
	    
	    public void setScore(String op)
	    {
	    	int playerScore = loginGUI.getPlayer().getScore();
	    	
	    	if(verifyCorrectAnswer(Integer.parseInt(op)))
	    	{
	    		loginGUI.getPlayer().setScore(playerScore+10);
	    		labScore.setText(String.valueOf(loginGUI.getPlayer().getScore()));
	    	}
	    	else
	    	{
	    		loginGUI.getPlayer().setScore(playerScore-10);
	    		labScore.setText(String.valueOf(loginGUI.getPlayer().getScore()));
	    	}
	    	
	    	showQuestions();
	    }
	    
	    
	    @FXML
	    public void selectOp1(ActionEvent event) 
	    {
	    	setScore(btnOp1.getText());
	    }

	    @FXML
	    public void selectOp2(ActionEvent event) 
	    {
	    	setScore(btnOp2.getText());
	    }

	    @FXML
	    public void selectOp3(ActionEvent event) 
	    {
	    	setScore(btnOp3.getText());
	    }

	    @FXML
	    public void selectOp4(ActionEvent event) 
	    {
	    	setScore(btnOp4.getText());
	    }

	  //Getters and Setters
		public Label getLabQuestion() {
			return labQuestion;
		}


		public Label getLabClock() {
			return labClock;
		}


		public Label getLabScore() {
			return labScore;
		}


		public Label getLabName() {
			return labName;
		}


		public void setLabQuestion(Label labQuestion) {
			this.labQuestion = labQuestion;
		}


		public void setLabClock(Label labClock) {
			this.labClock = labClock;
		}


		public void setLabScore(Label labScore) {
			this.labScore = labScore;
		}


		public void setLabName(Label labName) {
			this.labName = labName;
		}

	
	    
	    
}
