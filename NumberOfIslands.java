
public class NumberOfIslands {
	
	private void detectIsland(char[][] grid, int i, int j) {
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			if (i > 0) {
					detectIsland(grid, i-1, j);
			}
			if (i < grid.length-1) {
				detectIsland(grid, i+1, j);
			}
			if (j < grid[0].length-1) {
				detectIsland(grid, i, j+1);
			}
			if (j > 0) {
				detectIsland(grid, i, j-1);
			}
		} else {
			return;
		}
	}
	
    public int numIslands(char[][] grid) {
    	if (grid==null || grid.length==0 || grid[0].length==0) {
    		return 0;
    	}
        int numberOfIslands = 0;
        for (int i = 0;i != grid.length;i++) {
        	for (int j = 0;j != grid[0].length;j++) {
        		if (grid[i][j] == '1') {
        			numberOfIslands++;
        			detectIsland(grid, i, j);
        		}
        	}
        }
        return numberOfIslands;
    }
}
