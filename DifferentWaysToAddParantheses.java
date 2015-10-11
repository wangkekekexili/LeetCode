import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParantheses {
	
	private List<Integer> calculate(List<String> tokens, int start, int end) {
		List<Integer> currentResult = new ArrayList<>();
		if (start == end) {
			currentResult.add(Integer.parseInt(tokens.get(start)));
			return currentResult;
		}
		for (int separator = start + 1; separator < end; separator+=2) {
			List<Integer> left = calculate(tokens, start, separator-1);
			List<Integer> right = calculate(tokens, separator+1, end);
			for (Integer l : left) {
				for (Integer r : right) {
					switch (tokens.get(separator)) {
					case "+":
						currentResult.add(l + r);
						break;
					case "-":
						currentResult.add(l - r);
						break;
					case "*":
						currentResult.add(l * r);
						break;
					}
				}
			}
		}
		return currentResult;
	}
	
    public List<Integer> diffWaysToCompute(String input) {
        input = input.replaceAll("\\s", "");
        List<String> tokens = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        while (true) {
        	if (startIndex >= input.length()) {
        		break;
        	}
        	while (endIndex < input.length() && 
        			Character.isDigit(input.charAt(endIndex))) {
        		endIndex++;
        	}
        	tokens.add(input.substring(startIndex, endIndex));
        	if (endIndex < input.length()) {
        		tokens.add(input.substring(endIndex, endIndex+1));
        	}
        	endIndex++;
        	startIndex = endIndex;
        }
        return calculate(tokens, 0, tokens.size()-1);
    }
    
    public static void main(String[] args) {
    	DifferentWaysToAddParantheses instance = new DifferentWaysToAddParantheses();
    	String input = "2-1-1";
    	System.out.println(instance.diffWaysToCompute(input));
    }
}
