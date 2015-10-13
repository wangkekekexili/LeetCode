
public class PalindromePartitioningII {
	
    public int minCut(String s) {
    	if (s == null || s.length() <= 1) {
    		return 0;
    	}
    	int[] minCut = new int[s.length()+1];
    	for (int index = 0; index <= s.length(); index++) {
    		minCut[index] = index - 1;
    	}
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = 0; i-j>=0 && i+j<s.length() && s.charAt(i-j)==s.charAt(i+j);j++) {
    			minCut[i+j+1] = Math.min(minCut[i+j+1], 1+minCut[i-j]);
    		}
    		for (int j = 0; i-j>=0 && i+j+1<s.length() && s.charAt(i-j)==s.charAt(i+j+1);j++) {
    			minCut[i+j+2] = Math.min(minCut[i+j+2], 1+minCut[i-j]);
    		}
    	}
    	return minCut[s.length()];
    }
    
    public static void main(String[] args) {
    	PalindromePartitioningII instance = new PalindromePartitioningII();
    	System.out.println(instance.minCut("abbaa"));
    }
}
