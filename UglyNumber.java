/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * @author kewang
 *
 */
public class UglyNumber {
    public boolean isUgly(int num) {
    	if (num <= 0) {
    		return false;
    	}
	    if (num == 1) {
	 	    return true;
	    }
	    while (num % 2 == 0) {
 		    num /= 2;
   	    }
	    while (num % 3 == 0) {
		    num /= 3;
	    }
	    while (num % 5 == 0) {
		    num /= 5;
	    }
	    return num == 1;
    }
    
    public static void main(String[] args) {
    	UglyNumber test = new UglyNumber();
    	System.out.println(test.isUgly(14));
    	System.out.println(test.isUgly(16));
    }
}
