
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	if (s.length() == 0 && p.length() == 0) {
    		return true;
    	} else if (p.length() == 0) {
    		return false;
    	}
    	char patternChar = p.charAt(0);
    	boolean repeat = false;
    	if (p.length() >= 2 && p.charAt(1) == '*') {
    		repeat = true;
    	}
    	if (patternChar == '.') {
    		if (repeat == false) {
    			if (isMatch(s.substring(1), p.substring(1))) {
    				return true;
    			}
    		} else {
    			for (int index = 0; index <= s.length(); index++) {
    				if (isMatch(s.substring(index), p.substring(2))) {
    					return true;
    				}
    			}
    		}
    	} else {
    		if (repeat == false && s.charAt(0) != patternChar) {
    			return false;
    		} else {
    			if (repeat == false) {
    				return isMatch(s.substring(1), p.substring(1));
    			} else {
    				if (isMatch(s, p.substring(2))) {
    					return true;
    				}
					int startIndex = 0;
    				while (startIndex < s.length() && 
    						s.charAt(startIndex) == patternChar) {
    					startIndex++;
    					if (isMatch(s.substring(startIndex), p.substring(2))) {
    						return true;
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	RegularExpressionMatching instance = new RegularExpressionMatching();
    	System.out.println(instance.isMatch("aa", "a"));
    	System.out.println(instance.isMatch("aa", "aa"));
    	System.out.println(instance.isMatch("aaa", "aa"));
    	System.out.println(instance.isMatch("aa", "a*"));
    	System.out.println(instance.isMatch("aa", ".*"));
    	System.out.println(instance.isMatch("ab", ".*"));
    	System.out.println(instance.isMatch("aab", "c*a*b"));
    	System.out.println(instance.isMatch("a", "ab*"));
    }
}
