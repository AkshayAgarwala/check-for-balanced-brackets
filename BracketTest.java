import java.util.*;

/**
 *
 * @author Akshay Agarwala
 * Makes a stack with content of some ArrayList given by Main
 * Stack consists of left-sided brackets, parenthesis, and braces.
 * Terminates Program if input file is not balanced in brackets.
 * Input File is printed up to error in balancing or entire file otherwise.
 * *** Bracket refers to (, {, and [. ***
 *
 */
public class BracketTest {

	/**
	 * Input file content passed from main to makeStack method.
	 *
	 * @param input The content of the input file
	 */

	public void checkInputFileBalance(ArrayList<Character> input) {
		makeStack(input);
	} // checkInputFileBalance method

	/**
	 * Makes a DynamicStackArray of Characters.
	 * Any {, [, or ( are added onto the stack.
	 * Characters are popped from Stack if right-handed side occurs in the input file.
	 * MisMatches (not properly balanced) and other errors are checked for via other methods.
	 *
	 * @param info ArrayList containing content of input file
	 */
	private void makeStack (ArrayList<Character> info) {
		DynamicArrayStack<Character> result = new DynamicArrayStack<>();

		for (int i = 0; i < info.size(); i++) {
			char current = info.get(i);
			printChar(current); // print the char
			if (current == '{' || current == '[' || current == '(')
				result.push(current); // add desired chars to stack
			if (current == '}' || current == ']' || current == ')') {
				checkForExcessRightBrackets(result); // if Stack is empty nothing to pop - terminate
				char previous = result.pop();
				if(misMatch(previous, current)) // if current and previous char are not a pair
					errorMessage(previous);     // print error and terminate
			} // if right-sided bracket
		} // for loop

		// check if stack is now empty. If not, too many left-sided brackets. Not balanced - terminate.
		checkForExcessLeftBrackets(result);
	} // makeStack method

	/**
	 * Determines if two chars match (correct pair)
	 * Correct pairs are (), {}, or [].
	 *
	 * @param previous The char removed from the stack (left-sided)
	 * @param current The current char in the input file (right-sided)
	 * @return boolean True if two chars do not match
	 */
	private boolean misMatch(char previous, char current) {
		// if the chars are not a pair then return true
		if (previous == '{' && current != '}')
			return true;
		if (previous == '[' && current != ']')
			return true;
		if (previous == '(' && current != ')')
			return true;
		return false; // Chars are a pair so return false: no mismatch
	} // misMatch method

	/**
	 * Prints error message and terminates program.
	 *
	 * @param temp char value to be printed in the error message
	 */
	private void errorMessage(char temp) {
		System.out.println("\n\nERROR: Input File does not have a well-balanced "
				+ "'" + temp + "'");
		System.exit(1);
	} // errorMessage method

	/**
	 * Checks if too many right-sided brackets.
	 * If too many, prints a error message and terminates
	 *
	 * @param theStack stack containing the left sided brackets from the input file
	 */
	private void checkForExcessRightBrackets(DynamicArrayStack<Character> theStack) {
		// if input file has a right sided bracket but stack is empty there is an excess of right sided brackets.
		if(theStack.isEmpty()) {
			System.out.println("\n\nERROR: Excess Number of Right-Sided Brackets. File is not balanced.");
			System.exit(1);
		}
	} // checkForExcessRightBrackets method

	/**
	 * Checks if too many left-sided brackets.
	 * If too many, prints a error message and terminates.
	 * Otherwise prints that the file is balanced.
	 *
	 * @param theStack stack containing the left sided brackets from the input file
	 */
	private void checkForExcessLeftBrackets(DynamicArrayStack<Character> theStack) {
		// if stack isn't empty after being processed then there are still brackets that need to be balanced.
		if (!theStack.isEmpty()) {
			System.out.println("\n\nERROR: Excess Number of Left-Sided Brackets. File is not balanced.");
			System.exit(1);
		}
		else // otherwise the input file is balanced
			System.out.println("The Input File is well-balanced.\n");
	} // checkForExcessLeftBrackets method

	/**
	 * Prints a character
	 *
	 * @param c Char value to be printed
	 */
	private void printChar(char c) {
		System.out.print(c);
	} // printChar method

} // class
