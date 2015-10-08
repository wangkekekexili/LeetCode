
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	int max = 0;
    	if (matrix == null || matrix.length  == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int numberOfRows = matrix.length;
    	int numberOfColumns = matrix[0].length;
    	
    	int[] lastRow = new int[numberOfColumns];
    	for (int column = 0; column != numberOfColumns; column++) {
    		lastRow[column] = matrix[0][column] - '0';
    		if (lastRow[column] == 1) {
    			max = 1;
    		}
    	}
    	
    	
    	for (int row = 1; row < numberOfRows; row++) {
    		int[] currentRow = new int[numberOfColumns];
    		currentRow[0] = matrix[row][0] - '0';
    		if (currentRow[0] > max) {
    			max = 1;
    		}
    		for (int column = 1; column != numberOfColumns; column++) {
    			if (matrix[row][column] == '0') {
    				currentRow[column] = 0;
    			} else {
    				int temp = min(currentRow[column - 1],
    						lastRow[column], lastRow[column - 1]) + 1;
    				currentRow[column] = temp;
    				if (temp > max) {
    					max = temp;
    				}
    			}
    		}
    		lastRow = currentRow;
    	}
    	
    	return max;
    }
    
    private int min(Integer... ints) {
    	int min = Integer.MAX_VALUE;
    	for (int i : ints) {
    		if (i < min) {
    			min = i;
    		}
    	}
    	return min;
    }
}
