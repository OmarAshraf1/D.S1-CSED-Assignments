package eg.edu.alexu.csd.datastructure.hangman.cs50;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testgame {

	public static void main(String[] args) throws Exception {
		hanggame test = new hanggame() ;
		String dic[] = new String[] {"omar"};
	    test.setDictionary(dic);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(3);
		System.out.println(test.guess('o'));
		System.out.println(test.guess('m'));
		System.out.println(test.guess('t'));
		System.out.println(test.guess('i'));
		System.out.println(test.guess('a'));
		System.out.println(test.guess('r'));
		

		
	}


}
