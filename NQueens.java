import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * 
 * @author kewang
 *
 */
public class NQueens {
	private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
    	boolean[][] puzzle = new boolean[n][n];
    	for (int i = 0; i != n; i++) {
    		for (int j = 0; j != n; j++) {
    			puzzle[i][j] = false;
    		}
    	}
    	
    	solveNQueens(-1, puzzle, 0);
    	return result;
    }
    
    private void solveNQueens(int lastColumn, boolean[][] puzzle,
    		int numberOfQueens) {
    	if (numberOfQueens == puzzle.length) {
    		List<String> oneResult = new ArrayList<>();
    		for (int row = 0; row != puzzle.length; row++) {
    			StringBuilder sb = new StringBuilder(4);
    			for (int column = 0; column != puzzle.length; column++) {
    				if (puzzle[row][column] == true) {
    					sb.append("Q");
    				} else {
    					sb.append(".");
    				}
    			}
    			oneResult.add(sb.toString());
    		}
    		result.add(oneResult);
    		return;
    	}
    	int currentColumn = lastColumn+1;
    	for (int currentRow = 0; currentRow != puzzle.length; currentRow++) {
    		if (available(currentRow, currentColumn, puzzle)) {
    			puzzle[currentRow][currentColumn] = true;
    			solveNQueens(currentColumn, puzzle, numberOfQueens + 1);
    			puzzle[currentRow][currentColumn] = false;
    		}
    	}
    }
    
    private boolean available(int currentRow, int currentColumn, 
    		boolean[][] puzzle) {
    	if (currentRow >= 0 && currentRow < puzzle.length &&
    			currentColumn >= 0 && currentColumn < puzzle.length) {
    		for (int index = 0; index != puzzle.length; index++) {
    			if (puzzle[currentRow][index] == true) {
    				return false;
    			}
    		}
    		for (int i = currentRow, j = currentColumn; i >= 0 && j >= 0;
    				i--, j--) {
    			if (puzzle[i][j] == true) {
    				return false;
    			}
    		}
    		for (int i = currentRow, j = currentColumn; i < puzzle.length &&
    				j >= 0; i++, j--) {
    			if (puzzle[i][j] == true) {
    				return false;
    			}
    		}
    		return true;
    	} else {
    		return false;
    	}
    }
 
    public static void main(String[] args) {
    	NQueens instance = new NQueens();
    	//System.out.println(instance.solveNQueens(1));
    	System.out.println(instance.solveNQueens(4));
    }
}
