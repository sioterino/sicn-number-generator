package exceptions;

public class Validate {

	void validateExit(String input) {
		input = formating(input);

	}

	String formating(String input) {

		input = input.toLowerCase();
		String[] replace = {" ", ".", ",", ";", ".", "?", "!", "@", "#", "*"};
		for (int i = 0; i < input.length(); i++) {
			input = input.replace(replace[i], " ");
		}
		return input;

	}

}
