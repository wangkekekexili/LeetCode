import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combinations/
 * 
 * @author Ke Wang
 *
 */
public class Combinations {
    
	public static void calculate(List<List<Integer>> result,
			List<Integer> current,
			int start,
			int max,
			int remaining) {
		if (remaining == 0) {
			result.add(current);
			return;
		} 
		for (int i = start;i <= max-remaining+1;i++) {
			List<Integer> newList = new ArrayList<Integer>(current);
			newList.add(i);
			Combinations.calculate(result, newList, i+1, max, remaining-1);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (k > n) {
    		return result;
    	}
    	
    	Combinations.calculate(result, 
    			new ArrayList<Integer>(), 
    			1, 
    			n, 
    			k);
    	
    	return result;
    	
    }
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(4, 2).size());
	}
	
}
