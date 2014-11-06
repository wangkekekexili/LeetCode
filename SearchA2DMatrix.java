/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * * Integers in each row are sorted from left to right.
 * * The first integer of each row is greater than the last integer of the previous row.
 * 
 * 
 * @author Ke Wang
 *
 */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix==null) {
    		return false;
    	}
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	int first = 0;
    	int last = rows*columns-1;
    	int middle = 0;
    	while (true) {
    		middle = (first+last)/2;
    		int currentRow = middle / columns;
    		int currentCol = middle % columns;
    		if (matrix[currentRow][currentCol] == target) {
    			return true;
    		} else if (matrix[currentRow][currentCol] > target) {
    			last = middle-1;
    		} else if (matrix[currentRow][currentCol] < target) {
    			first = middle+1;
    		}
    		if (last < first) {
    			break;
    		}
    	}
    	return false;
    }
}
