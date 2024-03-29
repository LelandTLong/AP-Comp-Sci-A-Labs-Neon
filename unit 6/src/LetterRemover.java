//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{

		//call set
	}

	//add in second constructor
	public LetterRemover (String initial, char input){
		setRemover(initial, input);
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned = sentence.trim();
		for (int i = 0; i < sentence.length(); i++){
			if (cleaned.charAt(i) == lookFor){
				cleaned= cleaned.replace(lookFor, ' ');
			}
		}
		if (sentence.indexOf(' ') == -1){
		cleaned = cleaned.replaceAll(" ", "");
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + ": " + removeLetters();
	}
}