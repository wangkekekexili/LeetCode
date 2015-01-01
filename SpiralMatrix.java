import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * 
 * @author Ke Wang
 *
 */


// this version uses a magic number -99
public class SpiralMatrix {
	
	enum Direction{
		LEFT, RIGHT, UP, DOWN
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (matrix==null || matrix.length==0 || matrix[0].length==0) {
    		return list;
    	}
    	
    	int x = 0;
    	int y = 0;
    	Direction d = Direction.RIGHT;
    	
    	while (true) {
    		list.add(matrix[x][y]);
    		matrix[x][y] = -99;
			if (list.size() == matrix.length*matrix[0].length) {
				break;
			}
			int nextX = 0;
			int nextY = 0;
			switch (d) {
			case LEFT:
				nextX = x;
				nextY = y-1;
				if (y==0 || matrix[nextX][nextY]==-99) {
					nextX = x-1;
					nextY = y;
					d = Direction.UP;
				} 
				break;
			case RIGHT:
				nextX = x;
				nextY = y+1;
				if (y==matrix[0].length-1 || matrix[nextX][nextY]==-99) {
					nextX = x+1;
					nextY = y;
					d = Direction.DOWN;
				}
				break;
			case UP:
				nextX = x-1;
				nextY = y;
				if (x==0 || matrix[nextX][nextY]==-99) {
					nextX = x;
					nextY = y+1;
					d = Direction.RIGHT;
				}
				break;
			case DOWN:
				nextX = x+1;
				nextY = y;
				if (x==matrix.length-1 || matrix[nextX][nextY]==-99) {
					nextX = x;
					nextY = y-1;
					d = Direction.LEFT;
				}
				break;
			default:
				assert false;
			}
			x = nextX;
			y = nextY;
		}
		
    	return list;
    	
    	
    }
    
    public static void main(String[] args) {
    	SpiralMatrix m = new SpiralMatrix();
    	int[][] matrix = {{1},{2}};
    	List<Integer> list = m.spiralOrder(matrix);
    	for (Integer i : list) {
    		System.out.print(i+" ");
    	}
    }
    
}
