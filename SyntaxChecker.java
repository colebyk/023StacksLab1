//(c) A+ Computer Science
//www.apluscompsci.com

//Name -


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SyntaxChecker
{
	private Map<String, String> symbolPairs;
	private String text = "car(cdr(a)(b)))";
	private Stack<String> stack;
	
	public SyntaxChecker() {
		symbolPairs = new HashMap<String, String>();
		stack = new Stack<String>();
		symbolPairs.put(")", "(");
		symbolPairs.put("}", "{");
		symbolPairs.put(">", "<");
		symbolPairs.put("]", "[");

	}
	
	public void balanceCheck() {
		for (int i = 0; i < text.length(); i++) {
			if (symbolPairs.containsValue(Character.toString(text.charAt(i)))) { // if the current char in the text is an opening symbol
				stack.push(Character.toString(text.charAt(i))); // push that character to the stack
			} else if (symbolPairs.containsKey(Character.toString(text.charAt(i)))) { // else if the current char in the text is a closing symbol
				try {
					if (stack.pop().equals(symbolPairs.get(Character.toString(text.charAt(i))))) { // if the top char of the stack is the corresponding opening symbol
						// valid	
					} else { // if the top char of the stack is *not* the corresponding opening symbol
						System.out.println("Invalid statement");
						System.exit(0);
					}
				} catch (Exception e) { // catch the possible "pop when nothing is left in the stack" error
					System.out.println("Invalid statement. too many closing symbols");
					System.exit(0);
				}

			}
		}
		if (stack.isEmpty()) { // if there are no stray opening symbols in the stack
			System.out.println("valid statement");
		} else {
			System.out.println("Invalid statement");
		}
	}
}