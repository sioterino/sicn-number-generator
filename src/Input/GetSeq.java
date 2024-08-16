package input;

import exceptions.Validation;
import methods.Auxiliar;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GetSeq {
	public static int getsSequential(String name, int birth, int enroll, int seconds) {

		Scanner scanner = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String CONSOLE = "\u001B[35m";
		String WARNING = "\033[0;1m" + "\u001B[91m";


		boolean knows;
		String knowsStr;

		int sequential;
		String sequentialStr;

		System.out.println(CONSOLE+"\nNow we are going to averiguate your sequentional number, "+name+"."+RESET);
		
		while (true) {
			System.out.println("Do you happen do have a "+WARNING+"sequential number "+RESET+"pre determined?");
			knowsStr = scanner.nextLine();
			try {
				Validation.exit(knowsStr);
				Validation.eula(knowsStr);
				break;
			}  catch (Exception e) {
				System.out.println(WARNING + "You can only insert either \"true\" or \"false\" as a possible answer." + RESET);
			}
		}

		knows = Boolean.parseBoolean(knowsStr);

		if (!knows) {
			// user does NOT know their sequential number,
			// so you generate on [0-9] for them.
			System.out.println(CONSOLE + "That's okay!" + RESET);
			System.out.println(CONSOLE + "We will generate one for you!" + RESET);
			sequential = (int) (Math.random() * 10);

			// silly massage because im feeling silly today <3
			Auxiliar.delay(seconds, "checking for sequentials simmilar to yours", name);
			Auxiliar.replay(name, sequential, birth, enroll);


		} else { // boolean == true;
			// user DOES KNOW their sequential number,
			// so you ask them an input from [0-9].
			System.out.println("Could you provide us your sequential number?");
			while (true) {
				sequentialStr = scanner.nextLine();
				try {
					Validation.exit(sequentialStr);
					Validation.sequential(sequentialStr);
					break;

				} catch (Exception e) {
					System.out.println(WARNING + "Please, do only insert valid input." + RESET);
					System.out.println(WARNING+"Your number needs to be between \"0\" and \"9\"."+RESET);

				}

			} // ends WHILE LOOP.
			sequential = Integer.parseInt(sequentialStr);
		} // ends ELSE clause.

		return sequential;
	}
}
