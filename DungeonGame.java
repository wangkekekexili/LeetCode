
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
    	int rows = dungeon.length;
    	int cols = dungeon[0].length;
    	int[][] health = new int[rows][cols];
    	
    	// initialize
    	health[rows-1][cols-1] = dungeon[rows-1][cols-1];
    	for (int row = rows-2; row >= 0; row--) {
    		int currentHealth = dungeon[row][cols-1] + health[row+1][cols-1];
    		if (currentHealth > 0) {
    			health[row][cols-1] = 0;
    		} else {
    			health[row][cols-1] = 0;
    		}
    	}
    	for (int col = cols-2; col >= 0; col--) {
    		int currentHealth = dungeon[rows-1][col] + health[rows-1][col+1];
    		if (currentHealth > 0) {
    			health[rows-1][col] = 0;
    		} else {
    			health[rows-1][col] = 0;
    		}
    	}
    	
    	// dp
    	for (int row = rows-2; row >= 0; row--) {
    		for (int col = cols-2; col >= 0; col--) {
    			int currentHealth = dungeon[row][col] + 
    					(health[row+1][col]>health[row][col+1]?health[row+1][col]:health[row][col+1]);
    			if (currentHealth > 0) {
    				health[row][col] = 0;
    			} else {
    				health[row][col] = currentHealth;
    			}
    		}
    	}
    	return -health[0][0] + 1;
    }	
}
