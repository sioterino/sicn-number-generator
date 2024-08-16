package input;

import exceptions.*;
import methods.Formating;

import java.util.Scanner;

public class GetName {
	public static String getsName() {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";
		String WARNING = "\033[0;1m" + "\u001B[91m";

		String name;

		while (true) { // while loop

			// asks for a name.
			System.out.println("\nWhat is your name?");
			name = scanner.nextLine();

			// makes sure a string with only letters is being inserted.
			try {
				Validation.exit(name);
				Validation.str(name);
				break;
			} catch (Exception e) {
				System.out.println(WARNING + "Please, do insert a valid name." + RESET);
			}
		} // end of while loop

		// checking if the user's input is more than one word.
		if (name.matches(".*\\s.*")) {

			String[] birthCertificate = name.split(" ");
			String[] asianSurnames = {"kim", "lee", "choi", "kang", "jeon", "jung", "seo", "son", "min", "yoo", "yoon",
					"yu", "im", "lim", "hong", "huh","ko", "moon", "cho", "jo", "park", "chou", "minatozaki", "hirai",
					"myoui", "nakamura", "miyawaki", "nakamoto", "honda", "yabuki"};

			for (int i = 0; i < asianSurnames.length; i++) { // run through asianSurnames array
				if (Formating.format(birthCertificate[0]).equals(asianSurnames[i])) {
					// if it is an asian surname, then the second item is their given name.
					name = birthCertificate[1];
					break; // stop running through the array, we already have what we need.
				} else {
					// if it is NOT an asian name, the first one should be their given name.
					name = birthCertificate[0];
				}
			}

		}

		name = Formating.captalize(name);
		System.out.println(CONSOLE + "\nHello, " + name + ", the Console hopes you're good!" + RESET);

		return name;
	}
}
