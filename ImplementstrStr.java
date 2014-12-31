/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author Ke Wang
 *
 */

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
    	// java api
    	//return haystack.indexOf(needle);
    	
    	// brute force
    	for (int i = 0;i <= haystack.length()-needle.length();i++) {
    		boolean flag = true;
    		for (int j = 0;j != needle.length();j++) {
    			if (haystack.charAt(i+j) != needle.charAt(j)) {
    				flag = false;
    				break;
    			}
    		}
    		if (flag == true) {
    			return i;
    		}
    	}
    	return -1;
    	
    }
    
    public static void main(String[] args) {
    	ImplementstrStr i = new ImplementstrStr();
    	System.out.println(i.strStr("helloworld", "lo"));
    }
}
