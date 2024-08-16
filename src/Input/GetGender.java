package input;

import exceptions.Validation;

import java.util.Scanner;

public class GetGender {
	public static int getsGender(String name) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String WARNING = "\033[0;1m" + "\u001B[91m";
		String ORANGE = "\u001B[91m";


		int gender;
		String genterStr;

		System.out.println("\n" + name + ", with what gender identity do you identify yourself?");

		while (true) {
			System.out.println("""
					1.	Male;
					2.	Female;
					3.	Other.""");

			genterStr = scanner.nextLine();
			try {
				Validation.exit(genterStr, name);
				gender = Validation.gender(genterStr);
				break;
			} catch (Exception e) {
				System.out.println(WARNING + "\nPlease, do only insert valid input." + RESET);
				System.out.println(ORANGE + "\nYou can type the number of your answer," );
				System.out.println("the first letter of the gender you identify with,");
				System.out.println("or you can write down your full answer.\n" + RESET);
				System.out.println("How do identify yourself?");
			}

		}

		return gender;
	}
}
