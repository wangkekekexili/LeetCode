import java.util.OptionalInt;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author Ke Wang
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
    	if (A==null || A.length==0) {
    		return 0;
    	}
    	if (A.length==1) {
    		return 1;
    	}
    	int index = 0;
    	int i = 0;
    	OptionalInt optionalInt = OptionalInt.empty();
    	while (i < A.length) {
    		if (optionalInt.isPresent() == false) {
    			optionalInt = OptionalInt.of(A[i]);
    			A[index] = A[i];
    			index++;
    		} else {
    			if (A[i] != optionalInt.getAsInt()) {
    				optionalInt = OptionalInt.of(A[i]);
    				A[index] = A[i];
    				index++;
    			}
    		}
    		i++;
    	}
    	return index;
    }
}
