package eg.edu.alexu.csd.datastructure.hangman.cs50;

import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class hanggame implements Ihanggame {
	public String[] word;
	
	public String[] fileWords;
	
	public int i = 0;
	
	public String secretword;
	
	public int maxGuesses;
	
	public String gotLetters;
	
	public String solved = "";
	
	public int flag = 0;
	
	public String unsolvedWord = "";     
	
	public void readfile() throws IOException {

		try {
			 File	 file = new File("C:\\Users\\ﬂ„»ÌÊ ﬂ\\Desktop\\words.text") ;
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
				word[i] = line;

				i++;
			}
		} catch (IOException e) {
			throw new IOException();
		}
		setDictionary(word);

	}
	public void setDictionary(final String[] words) {
		
		fileWords = words;
	}
	public String selectRandomSecretWord() {

		Random number = new Random();
		if (fileWords == null || fileWords.length == 0) {
			return null;
		} else {
			secretword =
			fileWords[number.nextInt(fileWords.length)];
		}
		if (secretword != null) {
			for (i = 0; i < secretword.length(); i++) {
				unsolvedWord += "-";
			}
			gotLetters = secretword;
			return secretword;

		} else {
			return null;

		}

	}
	public String guess(final Character c) throws Exception {

		gotLetters = secretword;
		if (c == null) {
			return unsolvedWord;
		} else if (secretword == null) {
			throw new Exception();
		} else if (secretword == "" || secretword.charAt(0) == ' ') {
			throw new Exception();
		} else if (flag == 0) {
			throw new Exception();
		} else if (maxGuesses == 0) {
			return null;
		} else {
			char in1;
			char in2;

			in1 = Character.toUpperCase(c);
			in2 = Character.toLowerCase(c);

			if ((secretword.indexOf(c) >= 0)
					|| (secretword.indexOf(in2) >= 0)
					|| (secretword.indexOf(in1) >= 0)) {
				for (i = 0; i < secretword.length(); i++) {
					if (secretword.charAt(i) == c
					|| secretword.charAt(i) == in2
					|| secretword.charAt(i) == in1) {
					solved += (secretword.charAt(i));

					} else if (solved == null) {
						gotLetters =
						gotLetters.replace(
						gotLetters.charAt(i), '-');

					} else if (solved.indexOf(secretword.charAt(i)) < 0)
						 {
						gotLetters =
						gotLetters.replace(
						gotLetters.charAt(i), '-');

					}
				}
				unsolvedWord = gotLetters;
				return gotLetters;
			} else {
				for (i = 0; i < secretword.length(); i++) {
					if (solved == null) {
						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');
	
					} else if (solved.indexOf(
						secretword.charAt(i)) < 0) {
						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');	
					}
				}
				maxGuesses--;
				if (maxGuesses == 0) {
					return null;
				}
				unsolvedWord = gotLetters;
				return gotLetters;
			}
		}

	}
	public void setMaxWrongGuesses(final Integer max) {
		flag = 1;
		if (max == null) {
			maxGuesses = 1;
		} else {
			maxGuesses = max;
		}

	}
}
