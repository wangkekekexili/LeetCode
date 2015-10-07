import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * @author kewang
 *
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (nums == null || nums.length <= 1 || k == 0) {
    		return false;
    	}
    	TreeSet<Long> numbers = new TreeSet<>();
    	for (int index = 0; index != nums.length; index++) {
    		
    		Long current = new Long(nums[index]);
    		
    		// check if there exists satisfied number in the tree set
    		Long possible = numbers.floor(current + t);
    		if (possible != null && possible >= current - t) {
    			return true;
    		}
    		
    		// put the current number into the tree set
    		numbers.add(current);
    		if (index >= k) {
    			numbers.remove(new Long(nums[index - k]));
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	ContainsDuplicateIII instance = new ContainsDuplicateIII();
    	int[] nums = {1,3,1};
    	System.out.println(instance.containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}
