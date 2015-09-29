import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * @author kewang
 *
 */
public class CombinationSumIII {
	private List<List<Integer>> result = new ArrayList<>();
	private int length;
	private int target;
	private void solve(List<Integer> list, int next, int sum) {
		if (sum == target && list.size() == length) {
			List<Integer> newResultItem = new ArrayList<>(length);
			for (int i : list) {
				newResultItem.add(i);
			}
			result.add(newResultItem);
		} else if (sum >= target) {
			return;
		} else if (list.size() == length) {
			return;
		}
		for (int n = next; n <= 9; n++) {
			list.add(n);
			solve(list, n + 1, sum + n);
			list.remove(list.size() - 1);
		}
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	if (k > 9 || k <= 0 || n <= 0) {
    		return result;
    	}
    	length = k;
    	target = n;
    	solve(new ArrayList<>(), 1, 0);
    	return result;
    }
}
