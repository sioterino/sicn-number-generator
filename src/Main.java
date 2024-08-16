import input.*;
import methods.Auxiliar;

public class Main {
	public static void main(String[] args) {
/*
 *		setting colors correctly.
 */
		String RESET = "\u001B[0m";
		String WARNING = "\033[0;1m" + "\u001B[91m";

		Auxiliar.delay(2, "rebooting its system", "user");

		System.out.println(WARNING + "\nTyping down \"EXIT\" on the console ends the run without errors." + RESET);

		// GETTING THE USER'S NAME.
		String name = GetName.getsName();

		// SOME EULA AGREEMENT.
		Eula.agreement(name);

		// GETTING THE BIRTH YEAR
		int birth = GetBirth.getsBirth(name);

		// GETS GENDER IDENTITY.
		int gender = GetGender.getsGender(name);

		// GETTING THE ENROLLMENT YEAR.
		int enroll = GetEnroll.getsEnroll(name, birth);

		// GETS GRADE RETANTION AGE.
		int age = GetRetantion.getsRetantion(name, birth);

		// CALCULATES THE USER'S GRADE AND EDUCATIONAL LEVEL.
		int[] levelGrade = GetGradeLevel.getsGradeLevel(name, age);

		// GET THE CLASS ENROLLMENT.
		int schoolClass = GetClass.getsClass(name, levelGrade, 3);

		// GETS SEQUENTIAL NUMBER.
		int sequential = GetSeq.getsSequential(name, birth, enroll, 5);

		// GENERATES A SECURITY NUMBER.
		int security = GetSecurity.getsSecurity(enroll, birth, levelGrade, schoolClass, gender, sequential);

		// GENERATES FINAL STUDANT IDENTIFICATION CARD NUMBER
		GetSICN.getResults(name, enroll, birth, levelGrade, schoolClass, gender, sequential, security);

	}
}