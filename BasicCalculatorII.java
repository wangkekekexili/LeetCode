import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * @author kewang
 *
 */
public class BasicCalculatorII {
	
	class Tokenizer {
		String s;
		int startIndex;
		int endIndex;
		public Tokenizer(String s) {
			this.s = s;
			startIndex = 0;
			endIndex = 0;
		}
		String getNextToken() {
			String result = null;
			if (startIndex >= s.length()) {
				return result;
			}
			if ("+-*/".contains(s.substring(endIndex, endIndex+1))) {
				result = s.substring(endIndex, endIndex+1);
				startIndex = endIndex+1;
				endIndex = startIndex;
				return result;
			} else {
				while (endIndex < s.length() && 
						Character.isDigit(s.charAt(endIndex))) {
					endIndex++;
				}
				result = s.substring(startIndex, endIndex);
				startIndex = endIndex;
				return result;
			}
		}
	}
	
    public int calculate(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	s = s.replaceAll(" ", "");
    	Stack<Character> operator = new Stack<>();
    	Stack<Integer> tempResult = new Stack<>();
    	Tokenizer generator = new Tokenizer(s);
    	String token = null;
    	while ((token = generator.getNextToken()) != null) {
    		if (token.equals("+") || token.equals("-")) {
    			while (operator.isEmpty() == false) {
    				char op = operator.pop();
    				int secondOperand = tempResult.pop();
    				int firstOperand = tempResult.pop();
    				tempResult.add(calculate(firstOperand, op, secondOperand));
    			}
    			operator.add(token.charAt(0));
    		} else if (token.equals("*") || token.equals("/")) {
    			while (operator.isEmpty() == false && 
    					(operator.peek() == '*' || operator.peek() == '/')) {
    				char op = operator.pop();
    				int secondOperand = tempResult.pop();
    				int firstOperand = tempResult.pop();
    				tempResult.add(calculate(firstOperand, op, secondOperand));
    			}
    			operator.add(token.charAt(0));
    			
    		} else {
    			tempResult.add(Integer.parseInt(token));
    		}
    	}
    	while (operator.isEmpty() == false) {
    		char op = operator.pop();
			int secondOperand = tempResult.pop();
			int firstOperand = tempResult.pop();
			int temp = calculate(firstOperand, op, secondOperand);
			tempResult.add(temp);
    	}
    	return tempResult.pop();
    }
    
    private int calculate(int firstOperand, char operator, int secondOperand) {
    	switch (operator) {
    	case '+':
    		return firstOperand + secondOperand;
    	case '-':
    		return firstOperand - secondOperand;
    	case '*':
    		return firstOperand * secondOperand;
    	case '/':
    		return firstOperand / secondOperand;
		default:
			return 0;
    	}
    }
    
    public static void main(String[] args) {
    	BasicCalculatorII instance = new BasicCalculatorII();
    	System.out.println(instance.calculate("2*2+10"));
    }
}
