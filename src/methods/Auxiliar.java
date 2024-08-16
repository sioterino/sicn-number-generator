package methods;

import input.GetSecurity;

public class Auxiliar {

	public static String printable(int number) {

		String printable;

		if (number < 10) {
			printable = String.valueOf(number);
		} else {
			printable = String.valueOf(GetSecurity.digit(number, "first")) + String.valueOf(GetSecurity.digit(number, "last"));
		}

		return printable;
	}

	private static void progressPercentage(int remain, int total) {

		if (remain > total) {
			throw new IllegalArgumentException();
		}

		int maxBarSize = 20; // units for 100% (each unit represents 5%)
		int remainPorcent = ((100 * remain) / total) / (100 / maxBarSize);

		char defaultChar = '-';
		String icon = "*";

		String bar = new String(new char[maxBarSize]).replace('\0', defaultChar) + "]";

		String barDone = "[" + icon.repeat(Math.max(0, remainPorcent));

		String barRemain = bar.substring(remainPorcent);
		System.out.print("\r" + barDone + barRemain + " " + remainPorcent * (100 / maxBarSize) + "%");
		if (remain == total) {
			System.out.print("\n");
		}

	}

	public static void delay(double seconds, String text, String name) {

		String RESET = "\u001B[0m";
		String BLACK = "\u001B[30m";
		String bYELLOW = "\u001B[43m";
		String BOLD = "\033[0;1m";

		System.out.println("\nThe Console is currently " + text + ", " + name + ".");
		System.out.println("It might take a while, please be patiant.");
		System.out.print(BOLD + BLACK + bYELLOW);

		int millis = (int) (seconds * 5000) / 200;

		for (int remain = 0; remain <= millis; remain += 5) {
			progressPercentage(remain, millis);
			try {
				Thread.sleep(200); // Delay to simulate progress (200 milliseconds)
			} catch (Exception _) {
			}
		}

		System.out.println(RESET);

	}

	public  static void replay(String name, int sequential, int birth, int enroll) {

		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";

		switch (sequential) {

			case 0:
				System.out.println(CONSOLE + "It seems like you're unique in this school " + name + "!");
				System.out.println("The System says your sequential number is \"" + sequential + "\"." + RESET);
				break;
			case 9:
				System.out.println(CONSOLE + "Oh, there's so many people born in " + birth + " who've enrolled in " + enroll + "!");
				System.out.println("The System says your sequential number is \"" + sequential + "\"!" + RESET);
				break;
			default:
				System.out.println(CONSOLE + "It didn't take long, " + name + "!");
				System.out.println("The System says your sequential number is \"" + sequential + "\"." + RESET);

		}

	}

	public static void replay(int schoolClass) {

		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";

		char letter = switch (schoolClass) {
			case 2 -> 'B';
			case 3 -> 'C';
			case 4 -> 'D';
			default -> 'A';
		};

		System.out.println(CONSOLE + "Found it! You're enrolled in class " + letter + "!" + RESET);

	}

}
