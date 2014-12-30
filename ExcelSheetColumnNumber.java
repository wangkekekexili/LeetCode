
/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 
 * @author Ke Wang
 *
 */

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
    	if (s==null) {
    		return 0;
    	}
    	s =  s.toUpperCase();
    	for (int i = 0;i != s.length()-1;i++) {
    		char temp = s.charAt(i);
    		if (temp>='A'&&temp<='Z') {
    			continue;
    		} else {
    			return 0;
    		}
    	}
    	
    	
    	int times = 1;
    	int number = 0;
    	for (int i = s.length()-1;i >= 0;i--) {
    		number = number + times*((int)s.charAt(i)-(int)'A'+1);
    		times = times * 26;
    	}
    	return number;
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("ZY"));
	}

}
