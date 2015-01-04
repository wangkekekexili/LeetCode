import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/majority-element/
 * 
 * @author Ke Wang
 *
 */

public class MajorityElement {
    public int majorityElement(int[] num) {
    	if (num==null || num.length==0) {
    		return 0;
    	}
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0;i != num.length;i++) {
    		int result = map.getOrDefault(num[i], 0);
    		map.put(num[i],result+1);
    		if (result+1 > num.length/2) {
    			return num[i];
    		}
    	}
    	
    	return 0;
    	
    }
}
