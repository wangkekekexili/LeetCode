/**
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 * 
 * @author Ke Wang
 *
 */

public class SpiralMatrixII {
    
	enum Direction{
		LEFT, RIGHT, UP, DOWN
	}
	
	public int[][] generateMatrix(int n) {
		if (n<=0) {
			return new int[0][0];
		}
		int[][] matrix = new int[n][n];
		int x = 0;
		int y = 0;
		Direction d = Direction.RIGHT;
		
		int count = 1;
		int stop = n*n;
		
		while (true) {
			matrix[x][y] = count;
			if (count == stop) {
				break;
			}
			count++;
			int nextX = 0;
			int nextY = 0;
			switch (d) {
			case LEFT:
				nextX = x;
				nextY = y-1;
				if (y==0 || matrix[nextX][nextY]!=0) {
					nextX = x-1;
					nextY = y;
					d = Direction.UP;
				} 
				break;
			case RIGHT:
				nextX = x;
				nextY = y+1;
				if (y==n-1 || matrix[nextX][nextY]!=0) {
					nextX = x+1;
					nextY = y;
					d = Direction.DOWN;
				}
				break;
			case UP:
				nextX = x-1;
				nextY = y;
				if (x==0 || matrix[nextX][nextY]!=0) {
					nextX = x;
					nextY = y+1;
					d = Direction.RIGHT;
				}
				break;
			case DOWN:
				nextX = x+1;
				nextY = y;
				if (x==n-1 || matrix[nextX][nextY]!=0) {
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
		
		return matrix;
    	
    }

	public void printMatrix(int[][] m) {
		int n = m.length;
		for (int i = 0;i != n;i++) {
			for (int j = 0;j != n;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SpiralMatrixII m = new SpiralMatrixII();
		int[][] matrix = m.generateMatrix(4);
		m.printMatrix(matrix);
	}
}
