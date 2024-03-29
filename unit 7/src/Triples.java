//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

import java.io.Console;

public class Triples
{
   private int number;
   private int a = 3;
   private int b = 4;
   private int c = 5;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		
		if (a > b && a > c){
			for (int i = 1; i < a; i++){
				if (a%i==0 && b%i == 0 && c%i ==0){
					max = i;
				}
			}
		}
		
		if (b>a && b>c) {
			for (int i = 1; i < b; i++){
				if (a%i == 0 && b%i == 0 && c%i ==0){
					max = i;
				}
			}
		}
		
		else {
			for (int i = 1; i < c; i++){
				if (a%i == 0 && b%i == 0 && c%i ==0){
					max = i;
				}
			}
		}
		return max;
	}

	public String toString()
	{
		String output="";
		
		for (int i = 1; i <= number; i++){
			for (int j = 1; j <= number; j++){
				for (int k = 1; k <= number; k++){
					if ((i*i) + (j*j) == k*k){
						a = i;
						b = j;
						c = k;
						if ((a % 2 == 0 && b % 2 !=0) || (a%2 != 0 && b%2 ==0)){
							if (c%2 != 0){
								if (greatestCommonFactor(a,b,c) == 1){
									output = output + a + " " + b + " " + c + "\n";
								}
							}
						}
					}
				}
			}
		}





		return output +"\n";
	}
}