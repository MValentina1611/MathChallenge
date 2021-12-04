package thread;

import java.io.IOException;

import javafx.application.Platform;
import model.Timer;
import ui.QuestionsControllerGUI;

public class TimerThread extends Thread{

	private Timer timer;
	private QuestionsControllerGUI qcGUI;
	public TimerThread(Timer timer, QuestionsControllerGUI qcGUI)
	{
		this.timer = timer;
		this.qcGUI = qcGUI;
	}
	
	public void run()
	{
		while(timer.isRunning())
		{	

			System.out.println(timer.decreaseTime());
			Platform.runLater(new Thread() 
			{
				public void run() 
				{
					if(timer.getTime() > 0 )
					{
						qcGUI.refreshTimerlabel();
					}
					else
					{
						try {
							qcGUI.goToNextWindow();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						//timer.setRunning(false);
					}
				}
			});
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
