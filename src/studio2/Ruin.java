package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Starting Money: ");
		double startAmount = in.nextDouble();
		System.out.println("Win Probability: ");
		double winChance = in.nextDouble();
		System.out.println("Success Limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Number of simulations: ");
		int totalSimulations = in.nextInt();
		double expectedRuin;
		
		double ruin=0;
		double win=0;
		double a = (1-winChance)/winChance;
		if (winChance ==.5)
		{
			expectedRuin=1-(startAmount/winLimit);
		}
		else
		{
			expectedRuin=(Math.pow(a,startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		for (int i = 0; i<totalSimulations;i++)
		{
			int runTime = 0;
			double balance = startAmount;
			while((balance > 0) && (balance < winLimit))
			{
				boolean play = Math.random() <= winChance;
				if(play)
				{
					balance++;
				}
				else
				{
					balance--;
				}
				runTime++;
			}
			if(balance == 0)
			{
				System.out.println("You ruined in " + runTime + " plays.");
				ruin+=1;
			}
			else
			{
				System.out.println("You succeeded in " + runTime + " plays.");
				win+=1;
			}
		}
		System.out.println("Your ruin rate is: "+(ruin/(ruin+win)));
		System.out.println("Your expected ruin rate is: "+expectedRuin);

	}
}

