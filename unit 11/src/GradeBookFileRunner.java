//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		
		/*Class test = new Class(className,studentNum);
		while (file.hasNextLine()){
			String studentName = file.nextLine();
			String grades = file.nextLine();
			test.addStudent(studentNum,new Student(studentName,grades));
		}*/
		
		
		Scanner file = new Scanner(new File("C:\\Users\\Spam Sushi\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 11\\src\\gradebook.dat"));
		String className = file.nextLine();
		int studentNum = file.nextInt();
		String student = "";
		String grades = "";
		String trash = file.nextLine();
		Class test = new Class(className,studentNum);
		for (int i = 0; i < studentNum; i++){
			student = file.nextLine();
			grades = file.nextLine();
			test.addStudent(new Student(student,grades));
		}
		out.println(test);











	}		
}