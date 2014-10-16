/**
 * Determine if a Sudoku is valid
 * 
 * @author Ke Wang
 *
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	
    	// check if board is not null or not sudoku
    	if (board==null || board.length!=9 || board[0].length!=9) {
    		return false;
    	}
    		
    	// check if all chars are valid
    	for (int i = 0;i != 9;i++) {
    		for (int j = 0;j != 9;j++) {
    			if (board[i][j]=='.'||board[i][j]>='1'&&board[i][j]<='9') {
    				continue;
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	
    	boolean flags[] = new boolean[9];
    	// check all rows
    	for (int i = 0;i != 9;i++) {
    		// reset flags
    		for (int j = 0;j != 9;j++) {
    			flags[j] = false;
    		}
    		for (int j = 0;j != 9;j++) {
    			if (board[i][j] == '.') {
    				continue;
    			}
    			else {
    				if (flags[Character.getNumericValue(board[i][j])-1] == false) {
    					flags[Character.getNumericValue(board[i][j])-1] = true;
    				}
    				else {
    					return false;
    				}
    			}
    		}
    	}
    	
    	// check all columns
    	for (int i = 0;i != 9;i++) {
    		// reset flags
    		for (int j = 0;j != 9;j++) {
    			flags[j] = false;
    		}
    		for (int j = 0;j != 9;j++) {
    			if (board[j][i] == '.') {
    				continue;
    			}
    			else {
    				if (flags[Character.getNumericValue(board[j][i])-1] == false) {
    					flags[Character.getNumericValue(board[j][i])-1] = true;
    				}
    				else {
    					return false;
    				}
    			}
    		}
    	}
    	
    	// check all squares
    	for (int i = 0;i != 3;i++) {
    		for (int j = 0;j != 3;j++) {
    			for (int x = 0;x != 9;x++) {
    				flags[x] = false;
    			}
    			for (int k = 0;k != 3;k++) {
    				for (int l = 0;l != 3;l++) {
    					char current = board[i*3+k][j*3+l];
    					if (current=='.') {
    						continue;
    					}
    					else {
    						if (flags[Character.getNumericValue(current)-1] == false) {
    							flags[Character.getNumericValue(current)-1] = true;
    						}
    						else {
    							return false;
    						}
    					}
    				}
    			}
    		}
    	}
    	return true;
    }
    
}
