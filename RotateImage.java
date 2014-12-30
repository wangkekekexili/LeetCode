/**
 * https://oj.leetcode.com/problems/rotate-image/
 * Rotate the image by 90 degrees (clockwise).
 * 
 * @author Ke Wang
 *
 */

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix==null) {
			return;
		}
		int height = matrix.length;
		if (height==0) {
			return;
		}
		int width = matrix[0].length;
		if (height != width) {
			return;
		}
		
		for (int i = 0;i <= height/2-1;i++) {
			for (int j = 0;j <= width/2-1;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[height-1-j][i];
				matrix[height-1-j][i] = matrix[height-1-i][width-1-j];
				matrix[height-1-i][width-1-j] = matrix[j][width-1-i];
				matrix[j][width-1-i] = temp;
			}
		}
		
		if (height % 2 == 1) {
			for (int i = 0;i <= height/2-1;i++) {
				int temp = matrix[i][height/2];
				matrix[i][height/2] = matrix[height/2][i];
				matrix[height/2][i] = matrix[height-1-i][height/2];
				matrix[height-1-i][height/2] = matrix[height/2][height-1-i];
				matrix[height/2][height-1-i] = temp;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		new RotateImage().rotate(matrix);
	}
	
}
