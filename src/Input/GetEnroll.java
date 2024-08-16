package input;

import exceptions.Validation;
import java.util.Scanner;

public class GetEnroll {
	public static int getsEnroll(String name, int birth) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String WARNING = "\033[0;1m" + "\u001B[91m";
		String BLUE = "\u001B[34m";
		String BOLD = "\u001B[91m";

		int enroll;
		String enrollStr;

		System.out.println("\nWhen did you enroll in " + BLUE + "Hare Ridge Prep School" + RESET + ", " + name + "?");

		while (true) { // MAKES SURE ENROLLMENT YEAR IS BETWEEN age 2 & year 2022.
			while (true) { // GETS ENROLL YEAR
				enrollStr = scanner.nextLine();
				try {
					Validation.exit(enrollStr, name);
					Validation.year(enrollStr);
					break; // ends GETS ENROLL YEAR loop
				} catch (Exception e) {
					System.out.println(WARNING + "\nPlease, do insert a valid year.\n" + RESET);
					System.out.println("When did you enroll?");
				}
			}

			enroll = Integer.parseInt(enrollStr);
			if (enroll > 2022) { // the story takes place in 2022, you can't be enrolled in school being born in 2022.
				System.out.println(WARNING + "\nThe universe of \"" + BOLD + BLUE + "Only Bunnies Left" + WARNING + "\" is set in the year of 2022,");
				System.out.println(WARNING + "for you cannot be enrolled in " + enroll + ".\n" + RESET);

			} else if (enroll < birth) { // you were not even born, how could you be enrolled in that year?
				System.out.println(WARNING + "\nYou were not even born in " + enroll + " to be enrolled at school." + RESET);

			} else if (enroll == birth) { // you were bearly born, how could you be enrolled in that year?
			System.out.println(WARNING + "\nYou were bearly born in " + enroll + " to be enrolled at school." + RESET);

			} else if ((birth + 2) > enroll) { // you were under 2 years old, fore you couldn't be enrolled that year.
				System.out.println(WARNING + "\nYou were too young to be enrolled at " + enroll + RESET);

			} else {
				break; // ends MAKES SURE ENROLL YEAR loop
			}

			System.out.println(WARNING + "Please, insert a valid enrollment year.\n" + RESET);
			System.out.println("When did you enroll?");

		}

		return enroll;
	}
}
