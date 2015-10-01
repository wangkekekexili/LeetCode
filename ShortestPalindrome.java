/**
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * @author kewang
 *
 */
public class ShortestPalindrome {
    // The following solution uses too much memory
	/*
	public String shortestPalindrome(String s) {
    	if (s == null || s.length() <= 1) {
    		return s;
    	}
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	for (int length = 1; length <= s.length(); length++) {
    		for (int startIndex = 0; startIndex <= s.length() - length; 
    				startIndex++) {
    			int endIndex = startIndex + length - 1;
    			if (length == 1) {
    				isPalindrome[startIndex][endIndex] = true;
    			} else if (length == 2 && s.charAt(startIndex) == s.charAt(endIndex)) {
    				isPalindrome[startIndex][endIndex] = true;
    			} else if (s.charAt(startIndex) == s.charAt(endIndex) &&
    					isPalindrome[startIndex+1][endIndex-1] == true) {
    				isPalindrome[startIndex][endIndex] = true;
    			}
    			
    		}
    	}
    	int minIndexToCopy = 0;
    	for (int index = s.length() - 1; index >= 0; index--) {
    		if (isPalindrome[0][index] == true) {
    			minIndexToCopy = index + 1;
    			break;
    		}
    	}
    	
    	StringBuilder result = new StringBuilder(s);
    	for (int index = s.length() - 1; index >= minIndexToCopy; index--) {
    		result.insert(0, s.charAt(index));
    	}
    	return result.toString();
    }*/
	
	public String shortestPalindrome(String s) {
		int forwardIndex = 0;
		int backwardIndex = s.length() - 1;
		int toCopyIndex = s.length();
		char[] ch = s.toCharArray();
		
		while (forwardIndex < backwardIndex) {
			if (ch[forwardIndex] == ch[backwardIndex]) {
				forwardIndex++;
				backwardIndex--;
			} else {
				forwardIndex = 0;
				toCopyIndex--;
				backwardIndex = toCopyIndex - 1;
			}
		}
		
		return new StringBuilder(s.substring(toCopyIndex)).reverse().toString()
				+ s;
		
	}
    
    public static void main(String[] args) {
    	ShortestPalindrome instance = new ShortestPalindrome();
    	System.out.println(instance.shortestPalindrome("aacecaaa"));
    	System.out.println(instance.shortestPalindrome("abcd"));
    }
}
