import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author Ke Wang
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	if (s==null||s.length()==0){
    		return 0;
    	}
    	if (s.length()==1) {
    		return 1;
    	}
    	
    	int max = 0;
    	int count = 0;
    	int first = 0;
    	int last = 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	while (last < s.length()) {
    		if (map.get(s.charAt(last)) != null) {
    			int position = map.get(s.charAt(last)).intValue();
    			while (first <= position) {
    				map.remove(s.charAt(first));
    				first++;
    				count--;
    			}
    		}
    		
    		// add current char into the map
    		map.put(s.charAt(last), last);
    		count++;
    		if (count > max) {
    			max = count;
    		}
    		
    		last++;
    	}

    	return max;
    	
    }
    
    public static void main(String[] args) {
    	LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    	System.out.println("abcb:"+l.lengthOfLongestSubstring("abcb"));
    	System.out.println("bbbbb:"+l.lengthOfLongestSubstring("bbbbb"));
    	System.out.println("abcabcbb:"+l.lengthOfLongestSubstring("abcabcbb"));
    }
}
