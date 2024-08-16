package input;

import exceptions.Validation;
import methods.Auxiliar;

import java.util.Scanner;

public class GetSICN {
	public static void getResults(String name, int enroll, int birth, int[]levelGrade, int schoolClass, int gender, int sequential, int security) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";
		String WARNING = "\033[0;1m" + "\u001B[91m";
		String YELLOW = "\u001B[33m";
		String bYELLOW = "\u001B[43m";
		String BLACK = "\u001B[30m";
		String BOLD = "\033[0;1m";


		int level = levelGrade[0];
		int grade = levelGrade[1];

		int[] numbers = {enroll, birth, level, grade, schoolClass, gender, sequential, security};

		String outputStr;
		boolean output;

		System.out.println(CONSOLE + "\nThat's great, the console is done!" + RESET);

		while (true) {
			System.out.println("Are you ready for your" + YELLOW + " Student identification Card Number?" + RESET);
			outputStr = scanner.nextLine();
			try {
				Validation.exit(outputStr);
				Validation.eula(outputStr);
			} catch (Exception e) {
				System.out.println(WARNING + "You can only insert either \"true\" or \"false\" as a possible answer.\n" + RESET);
			}


			output = Boolean.parseBoolean(outputStr);

			if (output) { // when the user finally inserts TRUE.

				// runs through all the int numbers and turn them into the printable versions of theirselves.
				String sicn = "";
				for (int i = 0; i < numbers.length; i++) {
					// checks to add the - after the enroll + year numbers.
					if (i != 2 && i != 5) {
						sicn += Auxiliar.printable(numbers[i]);
					} else {
						sicn += "-" + Auxiliar.printable(numbers[i]);
					}

				}

				System.out.println(CONSOLE + "Here it is!" + RESET);
				System.out.println("\n" + BOLD + YELLOW + name + "'s SICN:" + BLACK + bYELLOW + sicn + RESET);
				System.out.println(CONSOLE + "\nHave fun with your new code, " + name + "!" + RESET);
				System.out.println(CONSOLE + "Have a good bye!" + RESET);
				break;

			} // end of OUTPUT == TRUE
		} // end of WHILE LOOP

		scanner.close();
	}


}
