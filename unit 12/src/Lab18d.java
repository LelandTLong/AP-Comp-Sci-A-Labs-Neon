//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		ArrayList<Word>order = new ArrayList<Word>();
		ArrayList<Word> temp = new ArrayList<Word>();
		Scanner file = new Scanner(new File("C:\\Users\\longl5895\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 12\\src\\lab18d.dat"));
		Word test;
		int size = file.nextInt();
		file.nextLine();
		while (file.hasNextLine()){
			test = new Word(file.nextLine());
			temp.add(test);
			
		}
		out.println(temp);
		
		/*for (int i = 0; i < order.size()-1; i++){
			
				if (temp.get(i).compareTo(temp.get(i+1)) == -1){
					order.add(0,temp.get(i));
				}
				else if (temp.get(i).compareTo(temp.get(i+1)) == 1){
					order.add(temp.get(i+1));
					order.add(temp.get(i));
				}
				else{
					order.add(temp.get(i));
				}
		}*/
		
		out.println(order);
		











	}
}