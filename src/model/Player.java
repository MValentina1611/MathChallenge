package model;

public class Player {

	private String name;
	private int score;
	
	private Player right;
	private Player left;
	
	
	public Player(String name)
	{
		this.name = name;
		score = 0;
	}

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getRight() {
		return right;
	}

	public Player getLeft() {
		return left;
	}

	public void setRight(Player right) {
		this.right = right;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public int compareTo(Player toCompare) 
	{
		return name.compareTo(toCompare.getName());
	}
	
	public int compareTo(String nameP)
	{
		return name.compareTo(nameP);
	}
	
}
