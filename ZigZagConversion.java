/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 * 
 * @author Ke Wang
 *
 */

// time limit exceeded
/*public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if (nRows == 1) {
    		return s;
    	}
    	char[][] matrix = new char[nRows][s.length()];
    	int currentRow = 0;
    	int currentColumn = 0;
    	boolean ifDown = true;
    	for (char ch : s.toCharArray()) {
    		matrix[currentRow][currentColumn] = ch;
    		if (currentRow == 0) {
    			ifDown = true;
    			currentRow = 1;
    		} else if (currentRow == nRows-1) {
    			ifDown = false;
    			currentRow--;
    			currentColumn++;
    		} else if (ifDown) {
    			currentRow++;
    		} else if (!ifDown) {
    			currentRow--;
    			currentColumn++;
    		} else {
    			assert false;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0;i != nRows;i++) {
    		for (int j = 0;j != s.length();j++) {
    			if (matrix[i][j] != 0) {
    				sb.append(matrix[i][j]);
    			}
    		}
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new ZigZagConversion().convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd", 4));
    }
}*/

// a newer version
public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if (nRows == 1) {
    		return s;
    	}
    	StringBuilder sb = new StringBuilder();
    	int interval = 2*(nRows-1);
    	int index = 0;
    	while (index < s.length()) {
    		sb.append(s.charAt(index));
    		index += interval;
    	}
    	
    	for (int i = 1; i <= nRows-2;i++) {
    		index = i;
    		while (index < s.length()) {
    			sb.append(s.charAt(index));
    			index += interval-2*i;
    			if (index < s.length()) {
    				sb.append(s.charAt(index));
    				index += 2*i;
    			}
    		}
    	}
    	
    	index = nRows-1;
    	while (index < s.length()) {
    		sb.append(s.charAt(index));
    		index += interval;
    	}
    	return sb.toString();
    }
    public static void main(String[] args) {
    	System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }
}