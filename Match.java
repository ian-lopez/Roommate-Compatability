import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Match 
{
	public static void main(String args[]) throws FileNotFoundException
	{		
		int studentCount = 0;
		
		
		Student[] students = new Student[100];
		
		//Reads the text file to retrieve the information on the students
		String filename = "FullRoster.txt";
		int t = 0;
		
		Scanner input = new Scanner(new FileReader(filename)); 
		
			while(input.hasNext()) 
			{ 
				Scanner line = new Scanner(input.nextLine()); 
				line.useDelimiter("[\t\r-]"); // Tab delimited file  
				
					String name = line.next();
					
					char gender = line.next().charAt(0);
					
					int year = line.nextInt();
					int month = line.nextInt();
					int day = line.nextInt();
					
					int quietTime = line.nextInt();
					int music = line.nextInt();
					int reading = line.nextInt();
					int chatting = line.nextInt();
					
					Preference preferences = new Preference(quietTime, music, reading, chatting);
					Date birthdate = new Date(year, month, day);
					students[t] = new Student(name, gender, birthdate, preferences);
				
					t++;	
					line.close();
			}
			input.close();
			
			for(int i = 0; i < t; i++)
			{
				int currentScore = 0;
				int bestMatchScore = 0;
				int maxScore = 0;
				int bestMatchStudent = 0;

				if(!students[i].getMatch())
				{
					for(int j = i + 1; j < t; j++)
					{
						if(!students[j].getMatch())
						{
							currentScore = students[i].compare(students[j]);
							if(currentScore > maxScore)
							{
								maxScore = currentScore;
								bestMatchStudent = j;
								bestMatchScore = maxScore;
							}
					}
				}
			
			String name1 = students[i] .getName();
			String bestMatchStudentName = students[bestMatchStudent].getName();
			if(bestMatchScore == 0)
			{
				System.out.println(name1 + " has no matches.");
			}
			else
			{
				students[i].setMatch();
				students[bestMatchStudent].setMatch();
				System.out.println(name1 + " matches with " + bestMatchStudentName + " with score " + bestMatchScore);
			}
				}
		} 
	}
}