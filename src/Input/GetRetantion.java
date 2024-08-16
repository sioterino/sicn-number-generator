package input;

import exceptions.Validation;
import java.util.Scanner;

public class GetRetantion {
	public static int getsRetantion(String name, int birth) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String WARNING = "\033[0;1m" + "\u001B[91m";

		boolean retained;
		String retainedStr;

		int repeat;
		String retention;

		while (true) { // WERE YOU EVER RETAINED?
			System.out.println("\nHave you ever been grade reteined?");
			retainedStr = scanner.nextLine();
			try {
				Validation.exit(retainedStr, name);
				Validation.eula(retainedStr);
				break;
			} catch (Exception e) {
				System.out.println(WARNING + "\nYou can only insert either \"true\" or \"false\" as a possible answer.\n" + RESET);
			}
		} // end WERE YOU EVER RETAINED?

		retained = Boolean.parseBoolean(retainedStr);

		if (!retained) { // user was NEVER retained.
			repeat = 0;
		} else { // user HAS BEEN retained.

			while (true) { // GETS RETENTION YEARS
				System.out.println("How many times have you been reteined?");
				retention = scanner.nextLine();
				try {
					Validation.exit(retention, name);
					Validation.retention(retention, birth);
					break;
				} catch (Exception e) {
					System.out.println(WARNING + "\nPlease, do only insert valid input.\n" + RESET);
				}
			}

			repeat = Integer.parseInt(retention);
		} // ends GETS RETENTION YEARS

		// relative age in relation to the retention.
		return 2022 - birth - repeat;

	}
}
