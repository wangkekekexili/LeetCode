import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * 
 * @author kewang
 *
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
    	int numbers = (int)Math.pow(2, n);
    	List<Integer> result = new ArrayList<Integer>(numbers);
    	boolean[] chs = new boolean[n];
    	result.add(0);
    	
    	grayCode(result, chs, 1);
    	return result;
    }
    
    private void grayCode(List<Integer> result, boolean[] current, int visited) {
    	if (visited == Math.pow(2, current.length)) {
    		return;
    	}
    	for (int i = 0; i != current.length; i++) {
    		if (current[i] == true) {
    			current[i] = false;
    		} else {
    			current[i] = true;
    		}
    		if (result.contains(toInt(current)) == false) {
    			result.add(toInt(current));
    			grayCode(result, current, visited+1);
    		}
    		if (current[i] == true) {
    			current[i] = false;
    		} else {
    			current[i] = true;
    		}
    	}
    }
    
    private int toInt(boolean[] array) {
    	int n = 0;
    	for (int i = 0; i < array.length; i++) {
    	    n = (n << 1) + (array[i] ? 1 : 0);
    	}
    	return n;
    }
    
    public static void main(String[] args) {
    	GrayCode instance = new GrayCode();
    	System.out.println(instance.grayCode(2));
    }
}
