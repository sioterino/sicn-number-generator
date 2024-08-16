package exceptions;

import methods.Formating;

public class Validation {

	public static void exit(String str) {
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";

		if (Formating.format(str).matches(".*exit.*")) {
			System.out.println(CONSOLE + "\nOh, that's too bad..." + RESET);
			System.out.println(CONSOLE + "Have a good bye!" + RESET);
			System.exit(0);
		}
	}

	public static void exit(String str, String name) {
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";

		if (Formating.format(str).matches(".*exit.*")) {
			System.out.println(CONSOLE + "\nOh, that's too bad..." + RESET);
			System.out.println(CONSOLE + "Have a good bye, " + name + "!" + RESET);
			System.exit(0);
		}
	}

	public static void str(String str) {
		if (Formating.format(str).matches(".*\\d.*")){
			throw new StringException();
		}
	}

	public static void eula(String str) {
		if (!Formating.format(str).matches(".*true|false.*")) {
			throw new BooleanException();
		}
	}

	public static void year(String str)  {
		if (str.length() != 4) {
			throw new YearException();
		}

	}

	public static void retention(String retention, int birth) {

		// calculates the age of the user.
		int age = 2022 - birth;

		if ((retention.length() <= 2 && retention.matches(".*\\d.*"))) {
			// if they were resonably reteined before.
			// parses how many times the user was reteined.
			int repeat = Integer.parseInt(retention);
			// calculates the relative age to retention
			age = age - repeat;

			if (repeat > 12 || repeat <1) {
				// if they were retained over 12 times, or under 1 time.
				throw new RetentionException();
			} else if (age < 2) {
				// if the relative age to retention is under 2 years old.
				throw new RetentionException();
			}

		} else { // if they were reteined for over 99 times, or no numbers were provided.
			throw new RetentionException();
		}
	}

	public static void schoolClass(String schoolClassStr, int level, int grade) {

		if (schoolClassStr.length() != 1 && !schoolClassStr.matches(".*\\d.*")) {
			// if class number is over 10 or doent contain numbers at all.
			throw new SchoolClassException();
		} else {
			// parse class to an int, so we can operate it.
			int schoolClass = Integer.parseInt(schoolClassStr);

			if ((level == 4 || level == 9) && grade <= 6) {
				// if user is in nursery or elementary school
				// there's only 2 classes they can't be enrolled at.
				if (schoolClass != 1 && schoolClass != 2) {
					throw new SchoolClassException();
				}

			} else if ((level == 9 || level == 3) && ((grade <= 9 && grade >= 7) || grade == 1)) {
				// if they're in middle school or 10th grade
				// there's only 3 classes they can be enrolled at.
				if (schoolClass < 1 || schoolClass > 3) {
					throw new SchoolClassException();
				}

			} else if (level == 3 && grade <= 3) {
				// if they're in 11th or 12th grades,
				// there's 4 classes they can be enrolled at.
				if (schoolClass < 1 || schoolClass > 4) {
					throw new SchoolClassException();
				}

			}

		}
		
	}

	public static int gender(String genderStr) {

		int gender = 0;

		if (Formating.format(genderStr).matches(".*\\d.*")) {
			// if user's input is a number.

			// if the user inputs more numbers and letters together.
			for (int i = 0; i < genderStr.length(); i++) {
				String letter = String.valueOf(Formating.format(genderStr).charAt(i));
				if (letter.matches("\\d")) {
					gender = Integer.parseInt(letter);
					break;
				}
			}

			if (gender < 1 || gender > 3) {
				throw new GenderException();
			}

			switch (gender) {
				case 1:
					gender = 2;
					break;
				case 2:
					gender = 1;
					break;
				case 3:
					gender = 0;
					break;
			}

		} else { // there is letters!
			if (Formating.format(genderStr).matches(".*^m.*")) {
				gender = 2;
			} else if (Formating.format(genderStr).matches(".*^f.*")) {
				gender = 1;
			} else if (Formating.format(genderStr).matches(".*^o.*")) {
				gender = 0;
			} else {
				throw new GenderException();
			}
		}

		return gender;
	}

	public static void sequential(String sequentialStr) {
		// if the string input does not have numbers or is more than 1 characyer long.
		if (!Formating.format(sequentialStr).matches(".*\\d.*") || Formating.format(sequentialStr).length() != 1) {
			throw new SequentialException();
		}

	}


}
