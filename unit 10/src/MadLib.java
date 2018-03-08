//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private String output;
	
	public MadLib()
	{



	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadAdjectives();
		loadVerbs();
		
		try{
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()){
				String reader = file.next();
				if (reader.equals("@")){
					
				}
				else if (reader.equals("#")){
					
				}
				else if (reader.equals("&")){
					
				}
				/*else{
					out.print(reader);
				}*/
			}
			
		
		
		
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File("C:\\Users\\longl5895\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 10\\src\\nouns.dat"));
			while (file.hasNext()){
				nouns.add(file.next());
			}
			
		
		
		
		}
		catch(Exception e)
		{
			out.println("test");
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("H:\\Unit10\\Unit10-2016\\Unit10-Assignments\\Lab16d\\verbs.dat"));
			while (file.hasNextLine()){
				verbs.add(file.nextLine());
			}
	
	
	
		}
		catch(Exception e)
		{
			out.println("nope");
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("H:\\Unit10\\Unit10-2016\\Unit10-Assignments\\Lab16d\\adjectives.dat"));
			while (file.hasNext()){
				verbs.add(file.next());
			}
		}
		catch(Exception e)
		{
		}
	}

	public String getRandomVerb()
	{
		String randomVerb;
		randomVerb = verbs.get((int) Math.random() * verbs.size());
		return randomVerb;
	}
	
	public String getRandomNoun()
	{
		String randomVerb;
		randomVerb = nouns.get((int) Math.random() * nouns.size());
		return randomVerb;
	}
	
	public String getRandomAdjective()
	{
		String randomVerb;
		randomVerb = adjectives.get((int) Math.random() * adjectives.size());
		return randomVerb;
	}		

	public String toString()
	{
	   return output;
	}
}