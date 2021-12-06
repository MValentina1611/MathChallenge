package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ScoreBoard;

public class ScoreBoardControllerGUI {


    @FXML
    private Label labPos1;

    @FXML
    private Label labPos2;

    @FXML
    private Label labPos3;

    @FXML
    private Label labPos5;

    @FXML
    private Label labPos4;

    @FXML
    private Label labPosP;

    @FXML
    private TextField txtSearchPalyer;

    @FXML
    private Label labSearchScore;

    @FXML
    private Button btnDeleteScore;
    
    //Attributes
    private LoginControllerGUI loginGUI;
    private ScoreBoard scoreBoard;
    
    public ScoreBoardControllerGUI(LoginControllerGUI loginGUI)
    {
    	this.loginGUI = loginGUI;
    	scoreBoard = new ScoreBoard();
    	
    }
    
    
    public void initializeWindow() throws IOException
    {
    	labPosP.setText(String.valueOf(loginGUI.getPlayer().getScore()));
    	scoreBoard.importData();
    	//scoreBoard.fillTop5();
    	//scoreBoard.printInorder(scoreBoard.getRootScore());
    	scoreBoard.addToTop5(scoreBoard.getRootScore());
    	setTop5(scoreBoard.getTop5().size());
    	System.out.println("Arraylist");
    	scoreBoard.printList(scoreBoard.getTop5(), 0);
    }
    
    
    private void setLabel(Label top,int pos )
    {
    	
    	top.setText(scoreBoard.getTop5().get(pos).getName());
    }
     
     
    public void setTop5(int positions) 
    {
    	//System.out.println(positions);
    	switch (positions) {
		case 1:
		{
			setLabel(labPos1, scoreBoard.getTop5().size()-1);
		}
			break;
			
		case 2:
		{
			setLabel(labPos1, scoreBoard.getTop5().size()-1);
			setLabel(labPos2, scoreBoard.getTop5().size()-2);			
		}
			break;
			
		case 3:
		{
			setLabel(labPos1, scoreBoard.getTop5().size()-1);
			setLabel(labPos2, scoreBoard.getTop5().size()-2);
			setLabel(labPos3, scoreBoard.getTop5().size()-3);
		}
			break;
			
		case 4:
		{
			setLabel(labPos1, scoreBoard.getTop5().size()-1);
			setLabel(labPos2, scoreBoard.getTop5().size()-2);
			setLabel(labPos3, scoreBoard.getTop5().size()-3);
			setLabel(labPos4, scoreBoard.getTop5().size()-4);
		}
			break;
		
		case 5:
		{
			setLabel(labPos1, scoreBoard.getTop5().size()-1);
			setLabel(labPos2, scoreBoard.getTop5().size()-2);
			setLabel(labPos3, scoreBoard.getTop5().size()-3);
			setLabel(labPos4, scoreBoard.getTop5().size()-4);
			setLabel(labPos5, scoreBoard.getTop5().size()-5);
		}
			break;
			
			default : 
				setTop5(5);
			
		}
    }
    
}
