import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
    	if (s == null) {
    		return 0;
    	}
    	s = s.replaceAll("\\s", "");
    	if (s.length() == 0) {
    		return 0;
    	}
    	List<String> token = new ArrayList<>();
    	int startIndex = 0;
    	int endIndex = 0;
    	while (true) {
    		if (endIndex >= s.length()) {
    			break;
    		}
    		while (endIndex < s.length() &&
    				Character.isDigit(s.charAt(endIndex)) == true) {
    			endIndex++;
    		}
    		if (startIndex != endIndex) {
    			token.add(s.substring(startIndex, endIndex));
    		}
    		
    		if (endIndex == s.length()) {
    			break;
    		}
    		
    		startIndex = endIndex;
    		if (s.charAt(endIndex) == '(') {
    			int count = 0;
    			while (endIndex < s.length()) {
    				if (s.charAt(endIndex) == '(') {
    					count++;
    				} else if (s.charAt(endIndex) == ')') {
    					count--;
    				}
    				endIndex++;
    				if (count == 0) {
    					break;
    				}
    			}
    			endIndex--;
    			token.add(Integer.toString(calculate(
    					s.substring(startIndex+1, endIndex))));
    		} else {
    			token.add(s.substring(endIndex, endIndex+1));
    		}
    		endIndex++;
    		startIndex = endIndex;
    	}
    	int result = 0;
    	boolean toAdd = true;
    	for (String t : token) {
    		if (t.equals("+")) {
    			toAdd = true;
    		} else if (t.equals("-")) {
    			toAdd = false;
    		} else {
    			int currentValue = Integer.parseInt(t);
    			if (toAdd) {
    				result += currentValue;
    			} else {
    				result -= currentValue;
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	BasicCalculator instance = new BasicCalculator();
    	System.out.println(instance.calculate("1 +1"));
    	System.out.println(instance.calculate(" 2-1 + 2 "));
    	System.out.println(instance.calculate("(1)"));
    	System.out.println(instance.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
