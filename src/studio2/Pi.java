package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double inCircle = 0;
		double outCircle = 0;
		System.out.println("Number of simulations: ");
		int totalSimulations = in.nextInt();
		for(int i = 0; i < totalSimulations; i++)
		{
			double x = Math.random();
			double y = Math.random();
			if(Math.pow(x, 2) + Math.pow(y, 2) <= 1)
			{
				inCircle++;
			}
			else
			{
				outCircle++;
			}
		}
		double approxPi = 4 * (inCircle/(inCircle + outCircle));
		System.out.print(approxPi);
	}

}
