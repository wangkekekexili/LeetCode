import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * 
 * @author Ke Wang
 *
 */
public class HappyNumber {

    public boolean isHappy(int n) {
    	Set<Integer> existingValues = new HashSet<>();
    	existingValues.add(n);
    	int newValue = n;
    	while (true) {
    		int oldValue = newValue;
    		newValue = 0;
    		while (oldValue != 0) {
    			newValue += Math.pow(oldValue % 10, 2);
    			oldValue /= 10;
    		}
    		System.out.println(newValue);
    		if (existingValues.contains(newValue) ) {
    			return false;
    		} else {
    			existingValues.add(newValue);
    		}
    		if (newValue == 1) {
    			return true;
    		}
    	}
    }
	
	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(2));
	}

}
