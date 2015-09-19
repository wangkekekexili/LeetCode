import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search/
 * 
 * @author kewang
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
    	if (word.trim().equals("")) {
    		return true;
    	}
    	// find all starter positions
    	Set<Position> start = new HashSet<>();
    	for (int i = 0; i != board.length; i++) {
    		for (int j = 0; j != board[0].length; j++) {
    			if (board[i][j] == word.charAt(0)) {
    				start.add(new Position(i, j));
    			}
    		}
    	}
    	
    	for (Position p : start) {
    		char temp = board[p.x][p.y];
    		board[p.x][p.y] = 0;
    		if (exist(board, p, word, 1)) {
    			return true;
    		}
    		board[p.x][p.y] = temp;
    	}
    	return false;
    }	
    
    private boolean exist(char[][] board, Position position, String word, 
    		int charsVisited) {
    	if (charsVisited == word.length()) {
    		return true;
    	}
    	char currentChar = word.charAt(charsVisited);
    	for (Direction direction : Direction.values()) {
    		position.increment(direction);
    		if (hasNextCharOnBoard(board, position, currentChar)) {
    			char temp = board[position.x][position.y];
    			board[position.x][position.y] = 0;
    			if (exist(board, position, word, charsVisited+1)) {
    				return true;
    			}
    			board[position.x][position.y] = temp;
    		}
    		position.decrement(direction);
    	}
    	return false;
    }
    
    private boolean hasNextCharOnBoard(char[][] board, Position position,
    		 char ch) {
    	if (position.x >= 0 && position.x < board.length &&
    			position.y >= 0 && position.y < board[0].length) {
    		if (board[position.x][position.y] == ch) {
    			return true;
    		}
    	}
    	return false;
    }
}

class Position {
	int x;
	int y;
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	void increment(Direction direction) {
		x += direction.increX();
		y += direction.increY();
	}
	void decrement(Direction direction) {
		x -= direction.increX();
		y -= direction.increY();
	}
}

enum Direction {
	NORTH(-1, 0),
	EAST(0, 1),
	SOUTH(1, 0),
	WEST(0, -1);
	
	private int x;
	private int y;
	
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int increX() {
		return x;
	}
	
	public int increY() {
		return y;
	}
}
