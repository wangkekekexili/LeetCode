/**
 * 
 * @author Ke Wang
 *
 */

public class UniquePaths {
	public int uniquePaths(int m, int c) {
		int paths[][] = new int[m][c];
		for (int i = 0;i != m;i++) {
			paths[i][0] = 1;
		}
		for (int i = 0;i != c;i++) {
			paths[0][i] = 1;
		}
		for (int i = 1;i !=m;i++) {
			for (int j = 1;j != c;j++) {
				paths[i][j] = paths[i][j-1] + paths[i-1][j];
			}
		}
		return paths[m-1][c-1];
	}
}
