/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * @author Ke Wang
 *
 */

public class LongestCommonPrefix {
	
	private boolean isCommon(String[] strs, int index) {
		char ch;
		if (strs[0].length() <= index) {
			return false;
		}
		ch = strs[0].charAt(index);
		for (int i = 1;i <= strs.length-1;i++) {
			if (strs[i].length() <= index) {
				return false;
			}
			if (strs[i].charAt(index) != ch) {
				return false;
			}
		}
		return true;
	}
	
    public String longestCommonPrefix(String[] strs) {
    	if (strs==null) {
    		return null;
    	}
    	if (strs.length==1) {
    		return strs[0];
    	}
    	
    	int index = 0;
    	while (this.isCommon(strs, index) == true) {
    		index++;
    	}
    	
    	return strs[0].substring(0,index);
    	
    }
    
    public static void main(String[] args) {
    	String s1 = "hello";
    	String s2 = "herro";
    	String s3 = "he";
    	String[] strs = {s1,s2,s3};
    	System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
