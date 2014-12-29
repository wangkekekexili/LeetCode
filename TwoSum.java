import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/two-sum/
 * 
 * @author Ke Wang
 *
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
    	
    	int[] result = new int[2];
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0;i != numbers.length;i++) {
    		map.put(new Integer(numbers[i]), new Integer(i));
    	}
    	
    	for (int i = 0;i != numbers.length;i++) {
    		int first = numbers[i];
    		//int secondIndex = map.getOrDefault(new Integer(target-first), new Integer(-1)).intValue();
    		Integer secondIndex = map.get(new Integer(target-first));
    		if (secondIndex != null && secondIndex.intValue() != i) {
    			result[0] = i+1;
    			result[1] = secondIndex.intValue()+1;
    			break;
    		}
    	}
    	
    	return result;
    	
    }
    
    public static void main(String[] args) {
    	int[] numbers = {3,2,4};
    	int target = 6;
    	int[] result = new TwoSum().twoSum(numbers, target);
    	System.out.println(result[0]+" "+result[1]);
    }
}
