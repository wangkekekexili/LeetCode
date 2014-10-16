
/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * 
 * @author Ke Wang
 * @version 9/22/2014   
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid==null) {
            return 0;
        }
        // attributes of the grid
        int rows = grid.length;
        int columns = grid[0].length;
        // the borders
        for (int i = 1;i <= columns-1;i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1;i <= rows-1;i++) {
            grid[i][0] += grid[i-1][0];
        }
        // dynamic programming
        for (int i = 1;i <= rows-1;i++) {
            for (int j = 1;j <= columns-1;j++) {
                if (grid[i][j-1]>grid[i-1][j]) {
                    grid[i][j] += grid[i-1][j];
                }
                else {
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        return grid[rows-1][columns-1];
    }
}
