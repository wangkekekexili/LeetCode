/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * @author kewang
 *
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	int x = 0;
    	int y = cols - 1;
    	while (x < rows && y >= 0) {
    		if (matrix[x][y] == target) {
    			return true;
    		} else if (matrix[x][y] > target) {
    			y--;
    		} else {
    			x++;
    		}
    	}
    	return false;
    }	
}
