import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutations/
 * 
 * @author Ke Wang
 *
 */
public class Permutations {
    
	public static void swap(List<Integer> l, int first, int second) {
		int temp = l.get(first);
		l.set(first, l.get(second));
		l.set(second, temp);
	}
	
	public static void permute(List<List<Integer>> result, 
			List<Integer> current, 
			int index) {
		if (index == current.size()-1) {
			result.add(current);
			return;
		}
		for (int i = index;i < current.size();i++) {
			List<Integer> newList = new ArrayList<Integer>(current);
			Permutations.swap(newList, index, i);
			Permutations.permute(result, newList, index+1);
		}
	}
	
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num==null) {
        	return result;
        }
        
        List<Integer> start = new ArrayList<Integer>();
        for (int i : num) {
        	start.add(i);
        }
        
        Permutations.permute(result, start, 0);
        
        return result;
    }
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] num = {1,2,3,4};
		List<List<Integer>> result = p.permute(num);
		System.out.println(result.size());
	}
}
