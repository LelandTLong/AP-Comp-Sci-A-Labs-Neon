//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("C:\\Users\\Spam Sushi\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 14\\src\\lab24d.dat"));
		int size = file.nextInt();
		file.nextLine();
		for (int i = 0; i< size; i++){
			String game = file.nextLine();
			TicTacToe test = new TicTacToe(game);
			out.println(test);
		}







	}
}



