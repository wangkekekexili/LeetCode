/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * @author Ke Wang
 *
 */
public class SortColors {
    public void sortColors(int[] A) {
        
    	if (A==null) {
        	return;
        }
    	
    	int arrayLength = A.length;
    	
    	/*// two pass methods
    	int red = 0;
    	int white = 0;
    	int blue = 0;
    	for (int i = 0;i != arrayLength;i++) {
    		if (A[i]==0) {
    			red++;
    		}
    		else if (A[i]==1) {
    			white++;
    		}
    		else if (A[i]==2) {
    			blue++;
    		}
    		else {
    			throw new IllegalArgumentException("COLOR NUMBER NOT EXPECTED");
    		}
    	}
    	int index = 0;
    	while (red!=0) {
    		A[index] = 0;
    		index++;
    		red--;
    	}
    	while (white!=0) {
    		A[index] = 1;
    		index++;
    		white--;
    	}
    	while (blue!=0) {
    		A[index] = 2;
    		index++;
    		blue--;
    	}*/
    	
    	// one pass
    	int index = 0;
    	int red = 0;
    	int blue = arrayLength-1;
    	while (index<=blue) {
    		if (A[index]==0) {
    			A[index] = A[red];
    			A[red] = 0;
    			red++;
    			index++;
    			continue;
    		}
    		else if (A[index]==1) {
    			index++;
    			continue;
    		}
    		else if (A[index]==2) {
    			A[index] = A[blue];
    			A[blue] = 2;
    			blue--;
    			continue;
    		}
    		else {
    			
    		}
    	}
    }
}
