package input;

import exceptions.Validation;

import java.util.Scanner;

public class Eula {
	public static void agreement(String name) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";
		String WARNING = "\033[0;1m" + "\u001B[91m";

		boolean eula;
		String eulaStr;

		System.out.println(CONSOLE + "\nNow, " + name + ", you are expected to answer some questions." + RESET);
		System.out.println(CONSOLE + "Is it okay with you?");

		while (true) {
			// can't ask for a nextBoolean because I still have to check if it is an "exit" string.
			eulaStr = scanner.nextLine();
			try	{
				Validation.exit(eulaStr, name);
				Validation.eula(eulaStr);
				break;
			} catch (Exception e) {
				System.out.println(WARNING + "\nYou can only insert either \"true\"\nor \"false\" as a possible answer." + RESET);
				System.out.println("\nAre you aware you will be subjected to some questions?");
			}
		}

		eula = Boolean.parseBoolean(eulaStr);
		if (eula) {
			System.out.println(CONSOLE + "Great!\n" + RESET);
		} else {
			Validation.exit("exit", name);
		}

	}
}
