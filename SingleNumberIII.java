/**
 * https://leetcode.com/problems/single-number-iii/
 * 
 * @author kewang
 *
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        
    	int a = 0;
    	int b = 0;
    	
    	int mark = 0;
        for (int num : nums) {
        	mark = mark ^ num;
        }
        int lastDiffBit = (mark & (mark-1)) ^ mark;
        for (int num : nums) {
        	if ((num & lastDiffBit) == 0) {
        		a = a ^ num;
        	} else {
        		b = b ^ num;
        	}
        }
        
        int[] result = {a, b};
        return result;
    }
}
