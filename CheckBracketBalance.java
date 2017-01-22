import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Akshay Agarwala
 * Opens input file and creates ArrayList of the text.
 * ArrayList is passed to BracketTest
 * Input file is printed entirely if file is balanced
 * Otherwise print stops when imbalance occurs
 * "Brackets" in the print refers to (), {}, and [].
 *
 */
public class CheckBracketBalance {
	public static void main(String[] args) throws IOException {

		FileInputStream fstream = new FileInputStream(args[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		int value = 0; // variable to hold value of input file chars
		ArrayList<Character> inputFile = new ArrayList<>();

		while ((value = br.read()) != -1) { // Each char from input file is read as an int
			inputFile.add((char) value);    // The int is casted as a char and added to the ArrayList
		}

		BracketTest input = new BracketTest(); // Create a new BracketTest object to test the input file
		
		input.checkInputFileBalance(inputFile); // calls a method from BracketTest and passes the ArrayList

		br.close();
	} // main
}
