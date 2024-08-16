package input;

public class GetGradeLevel {
	public static int[] getsGradeLevel (String name, int age) {

		String RESET = "\u001B[0m";
		String ORANGE = "\u001B[91m";
		String BLUE = "\u001B[34m";

		int[] grade = new int[2];

		switch (age) {

			case 1,2:
				grade[0] = 4; // level
				grade[1] = 1; // grade
				System.out.println("Then, you are currently enrolled in" + BLUE + " Nursery, grade 1." + RESET);
				break;
			case 3:
				grade[0] = 4;
				grade[1] = 2;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Nursery, grade 2." + RESET);
				break;
			case 4:
				grade[0] = 4;
				grade[1] = 3;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Kindergarten, grade 1." + RESET);
				break;
			case 5:
				grade[0] = 4;
				grade[1] = 4;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Kindergarten, grade 2." + RESET);
				break;
			case 6:
				grade[0] = 9;
				grade[1] = 1;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Elementary School, grade 1." + RESET);
				break;
			case 7:
				grade[0] = 9;
				grade[1] = 2;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Elementary School, grade 2." + RESET);
				break;
			case 8:
				grade[0] = 9;
				grade[1] = 3;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Elementary School, grade 3." + RESET);
				break;
			case 9:
				grade[0] = 9;
				grade[1] = 4;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Elementary School, grade 4." + RESET);
				break;
			case 10:
				grade[0] = 9;
				grade[1] = 5;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Middle School, grade 5." + RESET);
				break;
			case 11:
				grade[0] = 9;
				grade[1] = 6;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Middle School, grade 6." + RESET);
				break;
			case 12:
				grade[0] = 9;
				grade[1] = 7;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Middle School, grade 7." + RESET);
				break;
			case 13:
				grade[0] = 9;
				grade[1] = 8;
				System.out.println("Then, you are currently enrolled in" + BLUE + " Middle School, grade 8." + RESET);
				break;
			case 14:
				grade[0] = 9;
				grade[1] = 9;
				System.out.println("Then, you are currently enrolled in" + BLUE + " High School, grade 9." + RESET);
				break;
			case 15:
				grade[0] = 3;
				grade[1] = 1;
				System.out.println("Then, you are currently enrolled in" + BLUE + " High School, grade 10." + RESET);
				break;
			case 16:
				grade[0] = 3;
				grade[1] = 2;
				System.out.println("Then, you are currently enrolled in" + BLUE + " High School, grade 11." + RESET);
				break;
			case 17, 18, 19:
				grade[0] = 3;
				grade[1] = 3;
				System.out.println("Then, you are currently enrolled in" + BLUE + " High School, grade 12." + RESET);
				break;
			default:
				grade[0] = 3;
				grade[1] = 3;
				System.out.println("Then, you are currently enrolled in" + BLUE + " High School, grade 12." + RESET);
				System.out.println(ORANGE + "Are you sure you haven't been held back in school too many times, " + name + "?" + RESET);
		}


		return grade;
	}
}
