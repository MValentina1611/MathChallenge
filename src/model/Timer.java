package model;

public class Timer {

	private int time;
	private boolean running;
	
	public Timer()
	{
		time = 60;
		running = false;
	}
	
	//Cuando se abra la ventana del questions running pasa a true, y le comenzamos a decrease al time 
	public int decreaseTime()
	{
		if(running == true)
		{	
			time = time -1;
		}
		
		return time;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getTime() {
		return time;
	}


	
	
}

