import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
    	List<String> result = new ArrayList<>();
    	addOperators(result, "", num, 0, 0, 0, target);
    	return result;
    }
    
    private void addOperators(List<String> result, String last, String num, 
    		int currentIndex, long lastValue, long multi, int target) {
    	if (currentIndex == num.length() && lastValue == target) {
    		result.add(last);
    		return;
    	}
    	for (int index = currentIndex; index < num.length(); index++) {
    		if (index != currentIndex && num.charAt(currentIndex) == '0') {
    			break;
    		}
    		long currentValue = Long.parseLong(num.substring(currentIndex, index+1));
    		if (index == 0) {
    			addOperators(result, Long.toString(currentValue), num, index+1, currentValue, currentValue, target);
    		} else {
    			addOperators(result, last+"+"+Long.toString(currentValue), num, index+1, lastValue+currentValue, currentValue, target);
    			addOperators(result, last+"-"+Long.toString(currentValue), num, index+1, lastValue-currentValue, -currentValue, target);
    			addOperators(result, last+"*"+Long.toString(currentValue), num, index+1, lastValue-multi+multi*currentValue, multi*currentValue, target);
    		}
    	}
    }
    
}
