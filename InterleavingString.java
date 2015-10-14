
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1.length() + s2.length() != s3.length()) {
    		return false;
    	}
    	boolean[][] interleave = new boolean[s1.length()+1][s2.length()+1];
    	for (int i = 0; i <= s1.length(); i++) {
    		for (int j = 0; j <= s2.length(); j++) {
    			if (i == 0 && j == 0) {
    				interleave[0][0] = true;
    			} else if (i == 0) {
    				interleave[0][j] = interleave[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
    			} else if (j == 0) {
    				interleave[i][0] = interleave[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
    			} else {
    				interleave[i][j] = interleave[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)) ||
    						interleave[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
    			}
    		}
    	}
    	return interleave[s1.length()][s2.length()];
    }
	/* exceed time limit
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1.length() + s2.length() != s3.length()) {
    		return false;
    	}
    	return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    private boolean isInterleave(String s1, int s1Index, String s2,
    		int s2Index, String s3, int s3Index) {
    	if (s1.length() == s1Index) {
    		return s2.substring(s2Index).equals(s3.substring(s3Index));
    	}
    	if (s2.length() == s2Index) {
    		return s1.substring(s1Index).equals(s3.substring(s3Index));
    	}
    	char s1First = s1.charAt(s1Index);
    	char s2First = s2.charAt(s2Index);
    	char s3First = s3.charAt(s3Index);
    	if (s3First == s1First && s3First == s2First) {
    		return isInterleave(s1, s1Index+1, s2, s2Index, s3, s3Index+1) ||
    				isInterleave(s1, s1Index, s2, s2Index+1, s3, s3Index+1);
    	} else if (s3First == s1First) {
    		return isInterleave(s1, s1Index+1, s2, s2Index, s3, s3Index+1);
    	} else if (s3First == s2First) {
    		return isInterleave(s1, s1Index, s2, s2Index+1, s3, s3Index+1);
    	} else {
    		return false;
    	}
    }*/
}
