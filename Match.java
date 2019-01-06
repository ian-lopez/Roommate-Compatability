import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Match {
	public static void main(String args[]) throws FileNotFoundException

	{
		// int studentCount = 0;

		ArrayList<Student> students = readFiles();

		for (int i = 0; i < students.size(); i++) {
			int currentScore = 0;
			int bestMatchScore = 0;
			int maxScore = 0;
			int bestMatchStudent = 0;

			if (!students.get(i).getMatch()) {
				for (int j = i + 1; j < students.size(); j++) {
					if (!students.get(j).getMatch()) {
						currentScore = students.get(i).compare(students.get(j));
						if (currentScore > maxScore) {
							maxScore = currentScore;
							bestMatchStudent = j;
							bestMatchScore = maxScore;
						}
					}
				}

				String name1 = students.get(i).getName();
				String bestMatchStudentName = students.get(bestMatchStudent).getName();
				if (bestMatchScore == 0) {
					System.out.println(name1 + " has no matches.");
				} else {
					students.get(i).setMatch();
					students.get(bestMatchStudent).setMatch();
					System.out
							.println(name1 + " matches with " + bestMatchStudentName + " with score " + bestMatchScore);
				}
			}
		}
		yourBestMatch(students);
	}

	public static ArrayList<Student> readFiles() throws FileNotFoundException {

		ArrayList<Student> students = new ArrayList<Student>();
		// Reads the text file to retrieve the information on the students
		String filename = "FullRoster.txt";
		int t = 0;

		Scanner input = new Scanner(new FileReader(filename));

		while (input.hasNext()) {
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
			students.add(new Student(name, gender, birthdate, preferences));

			t++;
			line.close();
		}
		input.close();
		return students;
	}

	public static void yourBestMatch(ArrayList<Student> students) {
		System.out.println("========================================================");
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your First and last name: ");
		String name = in.nextLine();
		System.out.println("What is your gneder?\nEnter M for male or F for female: ");
		String genderS = in.nextLine();
		char gender = genderS.charAt(0);
		System.out.println("What is you date of birth, please enter as the following format" + "\nMM: ");
		int month = in.nextInt();
		System.out.println("DD: ");
		int day = in.nextInt();
		System.out.println("YYYY: ");
		int year = in.nextInt();
		System.out.println("aproximentaly how many hours do you dedicate to each of the following");
		System.out.println("quietTime: ");
		int quietTime = in.nextInt();
		System.out.println("music: ");
		int music = in.nextInt();
		System.out.println("reading: ");
		int reading = in.nextInt();
		System.out.println("chatting: ");
		int chatting = in.nextInt();
		Date birthdate = new Date(year, month, day);
		Preference pref = new Preference(quietTime, music, reading, chatting);
		Student stud = new Student(name, gender, birthdate, pref);
		findMyMatch(students, stud);

	}

	public static void findMyMatch(ArrayList<Student> students, Student student) {
		int currentScore = 0;
		int bestMatchScore = 0;
		int maxScore = 0;
		int bestMatchStudent = 0;
		for (int i = 0; i < students.size(); i++) {
			currentScore = students.get(i).compare(student);
			if (currentScore > maxScore) {
				maxScore = currentScore;
				bestMatchStudent = i;
				bestMatchScore = maxScore;
			}
		}

		String name1 = student.getName();
		String bestMatchStudentName = students.get(bestMatchStudent).getName();
		if (bestMatchScore == 0) {
			System.out.println(name1 + " has no matches.");
		} else {
			System.out.println(name1 + "\n Your best matches was " + bestMatchStudentName + " with a score of " + bestMatchScore);
		}
	}
}