/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * 
 * @author Ke Wang
 *
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        
    	if (matrix==null) {
    		return;
    	}
    	if (matrix.length == 0) {
    		return;
    	}
    	
    	// copy the matrix
    	int[][] originalMatrix = new int[matrix.length][matrix[0].length];
    	for (int i = 0;i != matrix.length;i++) {
    		for (int j = 0;j != matrix[0].length;j++) {
    			originalMatrix[i][j] = matrix[i][j];
    		}
    	}
    	
    	for (int i = 0;i != matrix.length;i++) {
    		for (int j = 0;j != matrix[0].length;j++) {
    			if (originalMatrix[i][j] == 0) {
    				for (int k = 0;k != matrix.length;k++) {
    					matrix[k][j] = 0;
    				}
    				for (int k = 0;k != matrix[0].length;k++) {
    					matrix[i][k] = 0;
    				}
    			}
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
