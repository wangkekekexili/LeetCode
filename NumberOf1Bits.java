/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * @author Ke Wang
 *
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        Long l = Integer.toUnsignedLong(n);
        int count = 0;
        while (l > 0) {
        	count += (l%2);
        	l /= 2;
        }
        return count;
    }
    public static void main(String[] args) {
    	NumberOf1Bits n = new NumberOf1Bits();
    	System.out.println(n.hammingWeight(11));
    }
}
