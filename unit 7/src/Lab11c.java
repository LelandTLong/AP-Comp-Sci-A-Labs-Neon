//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

import java.util.Scanner;

public class Lab11c
{
   public static void main( String args[] )
   {
	   int rows = 0;
	   String letter = "";
	   Scanner keyboard = new Scanner(System.in);
	   System.out.println("how many rows?");
	   rows = keyboard.nextInt();
	   System.out.println("what character?");
	   letter = keyboard.next();

	   TriangleThree test = new TriangleThree(rows,letter);
	   System.out.println(test);
	}
}