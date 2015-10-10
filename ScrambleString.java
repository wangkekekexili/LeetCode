/**
 * https://leetcode.com/problems/scramble-string/
 * 
 * @author kewang
 *
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
    	if (s1.length() != s2.length()) {
    		return false;
    	}
    	if (s1.equals(s2)) {
    		return true;
    	}
    	int[] charCount = new int[26];
    	for (int index = 0; index != s1.length(); index++) {
    		charCount[s1.charAt(index)-'a']++;
    		charCount[s2.charAt(index)-'a']--;
    	}
    	for (int index = 1; index <= s1.length()-1; index++) {
    		if (isScramble(s1.substring(0, index), s2.substring(0, index)) &&
    				isScramble(s1.substring(index), s2.substring(index))) {
    			return true;
    		}
    		if (isScramble(s1.substring(0,index), s2.substring(s2.length() - index)) &&
    				isScramble(s2.substring(0, s2.length() - index), s1.substring(index))) {
    			return true;
    		}
    	}
    	return false;
    }	
    
    public static void main(String[] args) {
    	ScrambleString instance = new ScrambleString();
    	System.out.println(instance.isScramble("ab", "ba"));
    	System.out.println(instance.isScramble("great", "rgtae"));
    }
}
