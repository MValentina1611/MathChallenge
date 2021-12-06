package model;

import java.util.ArrayList;

public class Questions {

	private int answer;
	private int op1;
	private int op2;
	private int op3;
	private String question;
	private ArrayList<Integer> options;
	
	public Questions()
	{
		answer = 0;
		op1 = 0;
		op2 = 0;
		op3 = 0;
		options = new ArrayList<Integer>();
	}
	
	public void generateQuestionWithOptions()
	{
		generateQuestion(generateOperator(),(int)(Math.random()*100),(int)(Math.random()*100));
		//System.out.println(question);
		//System.out.println(generateQuestion(generateOperator()));
		//System.out.println(answer);
		generateOptions();
		assignOptions();
		//System.out.println( op1 +""+ op2 +""+ op3 );
	}
	
	public void generateQuestion(int operator, int num1, int num2)
	{
		//System.out.println(operator);
		switch(operator)
		{
			case 1:
			{
				answer = num1 + num2;
				question = num1 + "+" + num2;
				
			}
			break;
			
			case 2:
			{
				answer = num1 - num2;
				question = num1 + "-" + num2;
				
			}
			break;
			
			case 3:
			{
				answer = num1 * num2;
				question = num1 + "x" + num2;
				
			}
			break;
			
			case 4:
			{
				if(num2 != 0 && num1%num2 == 0)
				{
					//System.out.println("se puede");
					answer = num1 / num2;
					question = num1 + "/" + num2;
				}
				else
				{
					num1 = (int)(Math.random()*100);
					num2 = (int)(Math.random()*100);
					generateQuestion(4, num1,num2);
				}
				
			}
			break;
		}
		
	}
	
	public int generateOperator()
	{
		int operator  = (int)(Math.random()*4+1);
		
		//System.out.println(operator);
		return operator; 
	}
	
	public void generateOptions()
	{
		while(options.size() < 3 )
		{
			//System.out.println("while");
			int result = (int)(Math.random()*100);
			if( result != answer && result <= answer+10 && result >= answer-10 && searchInOptions(result) == false && result !=0)
			{
				System.out.println(result);
				options.add(result);
				System.out.println("ADDED");
				generateOptions();
			}
			
		}
	}
	
	public void assignOptions()
	{
		System.out.println("assign");
		op1 = options.get(0);
		op2 = options.get(1);
		op3 = options.get(2);
	}

	public boolean searchInOptions(int toSearch)
	{
		boolean thereIs = false;
		if(options.size() > 0)
		{
			for(int i=0; i < options.size(); i++)
			{
				if(options.get(i) == toSearch)
				{
					thereIs = true;
				}
			}	
		}
		return thereIs;
	}
	
	//---------------Getters & Setters--------------------
	public int getAnswer() {
		return answer;
	}

	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}

	public int getOp3() {
		return op3;
	}
	
	public String getQuestion()
	{
		return question;
	}

	public ArrayList<Integer> getOptions() {
		return options;
	}
	
	
}

