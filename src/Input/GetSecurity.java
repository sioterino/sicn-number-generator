package input;

public class GetSecurity {
	public static int getsSecurity(int enroll, int birth, int[] levelGrade, int classSchool, int gender, int sequential) {

		int level = levelGrade[0];
		int grade = levelGrade[1];

		int equation = (digit(enroll, "first") * 2) + ((digit(enroll, "last") % 100) * 3)
				+ (digit(birth, "first") * 4) + (digit(birth, "last") * 5)
				+ (level * 6) + (grade * 7) + (classSchool * 8) + (gender * 9) + (sequential * 2);

		int security = (11 - (equation % 11)) % 10;

		return security;
	}

	public static int digit(int year, String digit) {

		double number = 0;
		switch (digit) {

			case "first":
				number = (double) (year % 100) / 10;
				break;

			case "last":
				number = year % 10;
				break;
		}

		return (int) number;
	}



}
