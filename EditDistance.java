/**
 * https://oj.leetcode.com/problems/edit-distance/
 * 
 * @author Ke Wang
 *
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null) {
        	return 0;
        }
        if (word1.length()==0) {
        	return word2.length();
        }
        if (word2.length()==0) {
        	return word1.length();
        }
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0;i < word1.length()+1;i++) {
        	dp[i][0] = i;
        }
        for (int i = 0;i < word2.length()+1;i++) {
        	dp[0][i] = i;
        }
        
        for (int i = 1;i < word1.length()+1;i++) {
        	for (int j = 1;j < word2.length()+1;j++) {
        		int temp = Integer.MAX_VALUE;
        		if (word1.charAt(i-1)==word2.charAt(j-1)) {
        			temp = dp[i-1][j-1];
        		}
        		if (dp[i-1][j-1]+1 < temp) {
        			temp = dp[i-1][j-1]+1;
        		}
        		if (dp[i-1][j]+1 < temp) {
        			temp = dp[i-1][j]+1;
        		}
        		if (dp[i][j-1]+1 < temp) {
        			temp = dp[i][j-1]+1;
        		}
        		dp[i][j] = temp;
        	}
        }
        
        return dp[word1.length()][word2.length()];
    }
}
