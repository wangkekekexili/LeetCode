import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * @author kewang
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	boolean[] canBeSegmented = new boolean[s.length()];
    	for (int start = 0; start <= s.length() - 1; start++) {
    		for (int len = 1; len <= s.length() - start; len++) {
    			// get substring from index 'start', and has length of 'len'
    			String current = s.substring(start, start + len);
    			if (wordDict.contains(current) && 
    					(start == 0 || canBeSegmented[start-1] == true)) {
    				canBeSegmented[start + len - 1] = true;
    			}
    		}
    	}
    	return canBeSegmented[s.length() - 1];
    }	
    
    public static void main(String[] args) {
    	String s = "dogs";
    	Set<String> dict = new HashSet<>();
    	dict.add("dog");
    	dict.add("s");
    	System.out.println(new WordBreak().wordBreak(s, dict));
    }
}
