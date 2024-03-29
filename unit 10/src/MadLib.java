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
import java.util.Random;

import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String output = "";
	
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
				if (reader.equals("#")) {
					output += (getRandomNoun() + " ");

				} else if (reader.equals("@")) {
					output += (getRandomVerb() + " ");
					
				} else if (reader.equals("&")) {
					output += (getRandomAdjective() + " ");
					
				} else {
					output += (reader + " ");

				}
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
			Scanner file = new Scanner(new File("C:\\Users\\Spam Sushi\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 10\\src\\nouns.dat"));
			while (file.hasNext()){
				nouns.add(file.next());
			}
			
		
		
		
		}
		catch(Exception e)
		{
			
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("C:\\Users\\Spam Sushi\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 10\\src\\verbs.dat"));
			while (file.hasNextLine()){
				verbs.add(file.next());
			}
	
	
	
		}
		catch(Exception e)
		{
			
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("C:\\Users\\Spam Sushi\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 10\\src\\adjectives.dat"));
			while (file.hasNext()){
				adjectives.add(file.next());
			}
		}
		catch(Exception e)
		{
		}
	}

	public String getRandomVerb()
	{
		Random test = new Random();
		int num = test.nextInt(verbs.size() - 1);
		return verbs.get(num);
	}
	
	public String getRandomNoun()
	{
		Random test = new Random();
		int num = test.nextInt(nouns.size() - 1);
		return nouns.get(num);
	}
	
	public String getRandomAdjective()
	{
		Random test = new Random();
		int num = test.nextInt(adjectives.size() - 1);
		return adjectives.get(num);
	}		

	public String toString()
	{
	   return output;
	}
}