
public class GameOfLife {
    public void gameOfLife(int[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) {
    		return;
    	}
    	for (int row = 0; row != board.length; row++) {
    		for (int col = 0; col != board[0].length; col++) {
    			int neighbor = liveNeighbor(board, row, col);
    			if (board[row][col] == 1 && neighbor == 2) {
    				board[row][col] = 3;
    			}
    			if (board[row][col] == 0 && neighbor == 3) {
    				board[row][col] = 2;
    			}
    		}
    	}
    	for (int row = 0; row != board.length; row++) {
    		for (int col = 0; col != board[0].length; col++) {
    			board[row][col] = board[row][col] >> 1;
    		}
		}
    }
    
    private int liveNeighbor(int[][] board, int row, int col) {
    	int result = 0;
    	if (row-1 >= 0 && col-1 >= 0) {
	    	if ((board[row-1][col-1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (row-1 >= 0) {
	    	if ((board[row-1][col] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (row-1 >= 0 && col+1 < board[0].length) {
	    	if ((board[row-1][col+1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (col-1 >= 0) {
	    	if ((board[row][col-1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (col+1 < board[0].length) {
	    	if ((board[row][col+1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (row+1 < board.length && col-1 >= 0) {
	    	if ((board[row+1][col-1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (row+1 < board.length) {
	    	if ((board[row+1][col] & 1) == 1) {
	    		result++;
	    	}
    	}
    	if (row+1 < board.length && col+1 < board[0].length) {
	    	if ((board[row+1][col+1] & 1) == 1) {
	    		result++;
	    	}
    	}
    	return result;
    }
}
