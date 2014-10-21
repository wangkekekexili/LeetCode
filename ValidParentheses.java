import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * @author Ke Wang
 *
 */



public class ValidParentheses {
    private boolean isPair(String left, String right) {
        return (left.equals("(")&&right.equals(")")) || 
        (left.equals("[")&&right.equals("]")) ||
        (left.equals("{")&&right.equals("}"));
    }
	public boolean isValid(String s) {
		if (s==null || s.equals("")) {
			return true;
		}
		Stack<String> stack = new Stack<String>();
		for (int i = 0;i != s.length();i++) {
			String currentChar = s.substring(i, i+1);
			if ("([{".contains(currentChar)) {
				stack.push(currentChar);
			}
			else if (")]}".contains(currentChar)) {
			    if (stack.isEmpty()) {
			        return false;
			    }
				String stackHead = stack.pop();
				if (!isPair(stackHead, currentChar)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
