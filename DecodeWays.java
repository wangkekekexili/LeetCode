
public class DecodeWays {
	
	private boolean hasResult(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return false;
		}
		for (int index = 0; index < s.length() - 1; index++) {
			if (s.charAt(index) == '0' && s.charAt(index+1) == '0') {
				return false;
			}
		}
		return true;
 	}
	
	public int numDecodings(String s) {
		if (!hasResult(s)) {
			return 0;
		}
		char[] numsAsChar = s.toCharArray();
		int[] nums = new int[s.length()];
		for (int index = 0; index != s.length(); index++) {
			nums[index] = numsAsChar[index] - '0';
		}
		int[] count = new int[s.length() + 1];
		count[s.length()] = 1;
		
		for (int index = s.length() - 1; index >= 0; index--) {
			if (nums[index] != 0) {
				count[index] = count[index+1];
			}
			if (index == s.length() - 1 || nums[index] == 0) {
				continue;
			}
			int current = nums[index]*10 + nums[index+1];
			if (current <= 26) {
				count[index] += count[index+2];
			}
		}
		return count[0];
	}
	/* exceed time limit
    public int numDecodings(String s) {
    	return decode(s);
    }	
    
    private int decode(String s) {
    	if (s.length() == 0) {
    		return 1;
    	} else if (s.length() == 1) {
    		return 1;
    	}
    	int result = 0;
    	
    	// first circumstance
    	result += decode(s.substring(1));
    	
    	// second circusmtance
    	int temp = Integer.parseInt(s.substring(0,2));
    	if (temp <= 26) {
    		result += decode(s.substring(2));
    	}
    	
    	return result;
    }*/
    
    public static void main(String[] args) {
    	DecodeWays instance = new DecodeWays();
    	System.out.println(instance.numDecodings("12"));
    	System.out.println(instance.numDecodings("10"));
    	System.out.println(instance.numDecodings("101"));
    }
}
