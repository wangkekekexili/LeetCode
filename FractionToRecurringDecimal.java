import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
    	
    	boolean sign = (numerator < 0) ^ (denominator < 0);
    	long n = numerator < 0 ? -(long)numerator : (long)numerator;
    	long d = denominator < 0 ? -(long)denominator : (long)denominator;
    	
    	long intPart = n / d;
        long remaining = n - intPart * d;    	
    	if (remaining == 0) {
    		if (intPart == 0) {
    			return "0";
    		} else {
    			return (sign?"-":"") + Long.toString(intPart);
    		}
    	}
    	
    	StringBuilder fraction = new StringBuilder();
    	Map<Long, Integer> map = new HashMap<>();
    	int startIndex = -1;
    	int currentIndex = -1;
    	
    	while (true) {
    		remaining *= 10;
    		if (map.get(remaining) != null) {
    			startIndex = map.get(remaining);
    			break;
    		} else {
    			currentIndex++;
    			map.put(remaining, currentIndex);
    			fraction.append(Long.toString(remaining / d));
    			remaining %= d;
    			if (remaining == 0) {
    				break;
    			}
    		}
    	}

    	if (startIndex != -1) {
			fraction.insert(startIndex, "(");
			fraction.append(")");
    	}
		
		return (sign?"-":"") + 
				Long.toString(intPart) + "." + fraction.toString();
    }
    
    public static void main(String[] args) {
    	FractionToRecurringDecimal instance = new FractionToRecurringDecimal();
    	System.out.println(instance.fractionToDecimal(1, 7));
    	System.out.println(instance.fractionToDecimal(2, 1));
    	System.out.println(instance.fractionToDecimal(-1, 7));
    	System.out.println(instance.fractionToDecimal(1, -7));
    	System.out.println(instance.fractionToDecimal(0, -7));
    	System.out.println(instance.fractionToDecimal(-1, -2147483648));
    }
}
