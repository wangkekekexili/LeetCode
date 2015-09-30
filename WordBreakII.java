import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	
	public boolean ifCanWordBreak(String s, Set<String> wordDict) {
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
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<>();

		// first check if there is any solution
		if (ifCanWordBreak(s, wordDict) == false) {
			return result;
		}
		
		List<List<String>> segments = new ArrayList<>(s.length());
		for (int index = 0; index != s.length(); index++) {
			segments.add(new ArrayList<>());
		}
    	for (int start = 0; start <= s.length() - 1; start++) {
    		for (int len = 1; len <= s.length() - start; len++) {
    			// get substring from index 'start', and has length of 'len'
    			String current = s.substring(start, start + len);
    			if (wordDict.contains(current) && 
    					(start == 0 || segments.get(start-1).size() != 0)) {
    				if (start == 0) {
    					segments.get(start+len-1).add(current+" ");
    				} else {
    					List<String> currentSegment = segments.get(start+len-1);
    					for (String old : segments.get(start-1)) {
    						currentSegment.add(old + current + " ");
    					}
    				}
    			}
    		}
    	}
    	
    	// remove all trailing zeros
    	for (String old : segments.get(s.length() - 1)) {
    		result.add(old.substring(0, old.length() - 1));
    	}
    	
    	return result;
	}
	
    public static void main(String[] args) {
    	String s = "catsanddog";
    	Set<String> dict = new HashSet<>();
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("sand");
    	dict.add("and");
    	dict.add("dog");
    	System.out.println(new WordBreakII().wordBreak(s, dict));
    }
}
