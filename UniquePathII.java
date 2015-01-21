/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * @author Ke Wang
 *
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid==null || obstacleGrid[0].length==0) {
    		return 0;
    	}
    	int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length]; 
    	
    	// the first row
    	for (int i = 0;i != obstacleGrid[0].length;i++) {
    		if (obstacleGrid[0][i] == 1) {
    			matrix[0][i] = 0;
    		} else {
    			if (i == 0) {
    				matrix[0][0] = 1;
    			} else {
    				matrix[0][i] = matrix[0][i-1];
    			}
    		}
    	}
    	
    	// the first column
    	for (int i = 1;i < obstacleGrid.length;i++) {
    		if (obstacleGrid[i][0] == 1) {
    			matrix[i][0] = 0;
    		} else {
    			matrix[i][0] = matrix[i-1][0];
    		}
    	}
    	
    	// the remaining
    	for (int i = 1;i < obstacleGrid.length;i++) {
    		for (int j = 1;j < obstacleGrid[0].length;j++) {
    			if (obstacleGrid[i][j] == 1) {
    				matrix[i][j] = 0;
    			} else {
    				matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
    			}
    		}
    	}
    	
    	// return 
    	return matrix[matrix.length-1][matrix[0].length-1];
    }
    
    public static void main(String[] args) {
    	UniquePathII u = new UniquePathII();
    	int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
    	System.out.println(u.uniquePathsWithObstacles(matrix));
    }
}
