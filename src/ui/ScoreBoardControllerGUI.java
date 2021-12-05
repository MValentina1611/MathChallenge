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
    	
    }
        
}
