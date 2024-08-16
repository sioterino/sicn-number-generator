package methods;

public class Formating {

	public static String captalize(String str) {
		str = String.valueOf(String.format(str).charAt(0)).toUpperCase() + format(str).substring(1);
		return str;
	}

	public static String format(String str) {

		// make every letter lower case, so the method becomes "ignore case".
		str = str.toLowerCase();

		// get rid of symbols and spaces so it works nonetheless.
		String[] replace = {" ", "'", ".", ",", ";", ".", "-", "?", "!", "@", "#", "*"};
		for (int i = 0; i < replace.length; i++) {
			str = str.replace(replace[i], "");
		}

		// array of special letters we'll be getting rid as well.
		char[][] letters = {
				{'á', 'à', 'â', 'ã', 'ä'},	// 0.
				{'é', 'è', 'ê', 'ë'},		// 1.
				{'í', 'ì', 'î', 'ï'},		// 2.
				{'ó', 'ò', 'ô', 'õ', 'ö'},	// 3.
				{'ú', 'ù', 'û', 'ü' },		// 4.
				{'ñ'},						// 5.
				{'ç'},						// 6.
		};

		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);

			// replacing all the As.
			for (int j = 0; j < letters[0].length; j++) {
				if (letter == letters[0][j]) {
					str = str.replace(letter, 'a');
				}
			}

			// replacing all the Es.
			for (int j = 0; j < letters[1].length; j++) {
				if (letter == letters[1][j]) {
					str = str.replace(letter, 'e');
				}
			}

			// replacing all the Is.
			for (int j = 0; j < letters[2].length; j++) {
				if (letter == letters[2][j]) {
					str = str.replace(letter, 'i');
				}
			}

			// replacing all the Os.
			for (int j = 0; j < letters[3].length; j++) {
				if (letter == letters[3][j]) {
					str = str.replace(letter, 'o');
				}
			}

			// replacing all the Us.
			for (int j = 0; j < letters[4].length; j++) {
				if (letter == letters[4][j]) {
					str = str.replace(letter, 'u');
				}
			}

			// replacing all the Ñ.
			if (letter == letters[5][0]) {
				str = str.replace(letter, 'n');
			}

			// replacing all the Ç.
			if (letter == letters[6][0]) {
				str = str.replace(letter, 'c');
			}

		}

		return str;

	}
}
