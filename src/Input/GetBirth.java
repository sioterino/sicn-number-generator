package input;

import exceptions.Validation;

import java.util.Scanner;

public class GetBirth {
	public static int getsBirth(String name) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String WARNING = "\033[0;1m" + "\u001B[91m";
		String BOLD = "\u001B[91m";
		String BLUE = "\u001B[34m";

		int birth;
		String birthStr;

		while (true) { // MAKES SURE YEAR IS BETWEEN AGES 30 AND 2.
			while (true) { // GETS THE YEAR.
				System.out.println("What year were you born?");
				birthStr = scanner.nextLine();
				try {
					Validation.exit(birthStr, name);
					Validation.year(birthStr);
					break; // ends GETS YEAR loop.
				} catch (Exception e) {
					System.out.println(WARNING + "\nPlease, do only insert a valid year number." + RESET);
				}
			}

			birth = Integer.parseInt(birthStr);
			int age = 2022 - birth;
			if (birth >= 2022) { // the story takes place in 2022, you can't be enrolled in school being born in 2022.
				System.out.println(WARNING + "\nThe universe of \"" + BOLD + BLUE + "Only Bunnies Left" + WARNING + "\" is set in the year of 2022,");
				System.out.println(WARNING+"for you cannot be born in " + birth + "." + RESET);

			} else if (age < 2)  { // you have to be over 2 years old to be able to enrolled at Hare Ridge Prep School.
				System.out.println(WARNING + "\nSorry, your year input is too low." + RESET);
				System.out.println(WARNING + "You are under the age of 2, for you are not allowed to enroll." + RESET);

			} else if (age > 30) { // you have to be under 30 years old to be able to enrolled at Hare Ridge Prep School.
				System.out.println(WARNING + "\nSorry, your year input is too high." + RESET);
				System.out.println(WARNING + "You are over the age of 30, for you are not allowed to enroll." + RESET);

			} else {
				break; // ends MAKES SURE loop.
			}

			System.out.println(WARNING + "Please, try again.\n" + RESET);
		}

		return birth;
	}
}
