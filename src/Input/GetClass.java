package input;

import exceptions.Validation;
import methods.Auxiliar;

import java.util.Scanner;

public class GetClass {
	public static int getsClass(String name, int[] levelGrade, int seconds) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";
		String WARNING = "\033[0;1m" + "\u001B[91m";


		int level = levelGrade[0];
		int grade = levelGrade[1];

		boolean knowsClass;
		String knowsClassStr;

		int schoolClass = 0;
		String schoolClassStr;

		while (true) {
			System.out.println("\nDo you know what class you are enrolled in?");
			knowsClassStr = scanner.nextLine();
			try {
				Validation.exit(knowsClassStr, name);
				Validation.eula(knowsClassStr);
				break;
			} catch (Exception e) {
				System.out.println(WARNING + "You can only insert either \"true\" or \"false\" as a possible answer." + RESET);
			}
		}


		knowsClass = Boolean.parseBoolean(knowsClassStr);
		if (!knowsClass) {
			// user does NOT know which class their enrolled.
			System.out.println(CONSOLE + "\nThat's okay!");
			System.out.println("We can look it up for you!" + RESET);

			if ((level == 4 || level == 9) && grade <= 6) {
				// from nursery to elementary school, there is 2 classes available.
				schoolClass = (int) (Math.random() * 2);
			} else if ((level == 9 || level == 3) && ((grade <= 9 && grade >= 7) || grade == 1)) {
				// from middle school to the 10th grade, there is 3 classes available.
				schoolClass = (int) (Math.random() * 3);
			} else if (level == 3 && grade <= 3) {
				// from 11th and 12th grades, there's 4 classes available.
				schoolClass = (int) (Math.random() * 4);
			}
			schoolClass++;

			//cool massage because i'm a little silly today
			Auxiliar.delay(seconds, "trying to fing which class you are enrolled in", name);
			Auxiliar.replay(schoolClass);

		} else {
			// user KNOWS which class they're enrolled at.
			System.out.println("Could you provide us your class number than, " + name + "?");
			while (true) {

				schoolClassStr = scanner.nextLine();
				try {
					Validation.exit(schoolClassStr);
					Validation.schoolClass(schoolClassStr, level, grade);
					break;
				} catch (Exception e) {
					System.out.println(WARNING + "\nPlease, do only insert valid input." + RESET);
				}

			}

			schoolClass = Integer.parseInt(schoolClassStr);
		}

		return schoolClass;
	}
}
