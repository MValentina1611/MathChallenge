package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreBoard {

	private Player rootName;
	private Player rootScore;
	private String FILE_IMPORT_PLAYERS_CSV_PATH = "data/PlayerDataExported.csv";
	private String FILE_EXPORT_PLAYERS_CSV_PATH = "data/PlayerDataExported.csv";
	
	
	public void addPlayerBothWays(Player newPlayer) throws IOException
	{
		addPlayerByScore(newPlayer.getName(), newPlayer.getScore());
		addPlayerByName(newPlayer.getName(), newPlayer.getScore());
		exportData(newPlayer);
	}
	
	
	public void addPlayerByScore(String name, int score)
	{
		Player newPlayer = new Player(name, score);
		
		if(rootScore == null)//vacía
		{
			rootScore = newPlayer;
		}
		else //tiene al menos uno
		{
			Player temp = rootScore;
			boolean added = false;
			while( !added )
			{	
				if(newPlayer.getScore() <= temp.getScore())
				{
					if( temp.getLeft() == null)
					{
						temp.setLeft(newPlayer);
						added = true;
					}
					else
					{
						temp = temp.getLeft();
					}

				}
				else
				{
					if( temp.getRight() == null)
					{
						temp.setRight(newPlayer);
						added = true;
					}
					else
					{
						temp = temp.getRight();
					}
				}
			}
		}
		
	}
	public void addPlayerByName(String name, int score)
	{
		Player toAdd = new Player(name, score);
		if( rootName == null)
		{
			rootName = toAdd;
		}
		else
		{
			addPlayerByName(toAdd, rootName );
		}
	}
	
	public void addPlayerByName(Player newP, Player current ) 
	{
		 
			if( newP.compareTo(current) < 0 ) 
			{
				if(current.getLeft() != null) 
				{
					addPlayerByName(newP,current.getLeft());
				} 
				else 
				{
					current.setLeft(newP);
				}
			}
			else if( newP.compareTo(current) >= 0)
			{		
				if(current.getRight() != null) 
				{
					addPlayerByName(newP, current.getRight());
				} 
				else 
				{
					current.setRight(newP);
				}
			}
	}
	
	public Player searchPlayer(String name)
	{
		if(rootName == null)
		{
			return null;
		}
		else
		{
			return searchPlayer(rootName, name);
		}

	}
	
	public Player searchPlayer(Player current, String name)
	{
		if( current == null)
		{
			return current;
		}
		else if(current.getName().equalsIgnoreCase(name ))
		{
			return current;
		}
		else if( current.compareTo(name) >= 0 )
		{
			return searchPlayer(current.getLeft(), name);
		}
		else
		{
			return searchPlayer(current.getRight(), name);
		}
		
	}
	
	public void importData() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FILE_IMPORT_PLAYERS_CSV_PATH) );
		String line = br.readLine();
		
		while( line != null && line.length() > 0 )
		{
			String [] info = line.split("\\|");
			String name = info[0];
			System.out.println(name);
			try 
			{
				int score = Integer.parseInt(info[1]);						
				addPlayerByName(name,score);
				addPlayerByScore(name, score);
				
			}
			catch(NumberFormatException ex){}
								
			line = br.readLine();
		}	
		br.close();
	}
	
	
	public void exportData(Player playerToExport ) throws IOException
	{
		FileWriter fw = new FileWriter( FILE_EXPORT_PLAYERS_CSV_PATH, true );
		
			fw.write(playerToExport.getName() + "|" + playerToExport.getScore()+"\n");
			
		fw.close();
	}

	
	

}
